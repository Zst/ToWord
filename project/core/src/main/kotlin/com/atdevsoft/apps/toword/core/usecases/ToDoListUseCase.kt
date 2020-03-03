package com.atdevsoft.apps.toword.core.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.atdevsoft.apps.toword.core.database.ToDo as ToDoDb
import com.atdevsoft.apps.toword.core.database.ToDoRepository
import com.atdevsoft.apps.toword.core.database.toother.ToOther as ToOtherDb
import com.atdevsoft.apps.toword.core.database.toother.ToOtherRepository
import com.atdevsoft.apps.toword.core.database.toread.ToRead as ToReadDb
import com.atdevsoft.apps.toword.core.database.toread.ToReadRepository
import com.atdevsoft.apps.toword.core.database.towatch.ToWatch as ToWatchDb
import com.atdevsoft.apps.toword.core.database.towatch.ToWatchRepository
import com.atdevsoft.apps.toword.core.mapper.Mapper
import com.atdevsoft.apps.toword.core.model.ToDo
import com.atdevsoft.apps.toword.core.model.ToOther
import com.atdevsoft.apps.toword.core.model.ToRead
import com.atdevsoft.apps.toword.core.model.ToWatch
import kotlinx.coroutines.runBlocking

abstract class ToDoListUseCase<T : ToDo, D : ToDoDb, R : ToDoRepository<D>>(
    protected val repository: R,
    private val mapper: Mapper<D, T>
) {
    protected abstract fun getAllItemsDbLiveData(): LiveData<List<D>>
    protected abstract suspend fun getAllItemsDb(): List<D>
    protected abstract suspend fun getItemById(itemId: Long): D

    fun getAllItemsLiveData(): LiveData<List<T>> {
        return Transformations.map(getAllItemsDbLiveData()) { list ->
            list.map {
                runBlocking {
                    mapper.map(it)
                }
            }
        }
    }

    suspend fun getAllItems(): List<T> {
        return getAllItemsDb().map { mapper.map(it) }
    }

    suspend fun markAsDone(item: T, done: Boolean, wouldRecommend: Boolean?): T {
        val dbItem = getItemById(item.id)
        @Suppress("UNCHECKED_CAST")
        val result = dbItem.copy(
            dbItem.toDoSummary.copy(
                isDone = done,
                wouldRecommend = wouldRecommend
            )
        ) as D
        repository.updateItem(result)
        return mapper.map(result)
    }

    suspend fun delete(item: T) {
        val dbItem = getItemById(item.id)
        repository.deleteItem(dbItem)
    }
}

class ToWatchListUseCase(repository: ToWatchRepository, mapper: Mapper<ToWatchDb, ToWatch>) :
    ToDoListUseCase<ToWatch, ToWatchDb, ToWatchRepository>(repository, mapper) {
    override fun getAllItemsDbLiveData(): LiveData<List<ToWatchDb>> =
        repository.getAllItemsLiveData()

    override suspend fun getAllItemsDb(): List<ToWatchDb> = repository.getAllItems()
    override suspend fun getItemById(itemId: Long): ToWatchDb = repository.getItemById(itemId)
}

class ToReadListUseCase(repository: ToReadRepository, mapper: Mapper<ToReadDb, ToRead>) :
    ToDoListUseCase<ToRead, ToReadDb, ToReadRepository>(repository, mapper) {
    override fun getAllItemsDbLiveData(): LiveData<List<ToReadDb>> =
        repository.getAllItemsLiveData()

    override suspend fun getAllItemsDb(): List<ToReadDb> = repository.getAllItems()
    override suspend fun getItemById(itemId: Long): ToReadDb = repository.getItemById(itemId)
}

class ToOtherListUseCase(repository: ToOtherRepository, mapper: Mapper<ToOtherDb, ToOther>) :
    ToDoListUseCase<ToOther, ToOtherDb, ToOtherRepository>(repository, mapper) {
    override fun getAllItemsDbLiveData(): LiveData<List<ToOtherDb>> =
        repository.getAllItemsLiveData()

    override suspend fun getAllItemsDb(): List<ToOtherDb> = repository.getAllItems()
    override suspend fun getItemById(itemId: Long): ToOtherDb = repository.getItemById(itemId)
}
