package com.atdevsoft.apps.toword.core.usecases

import com.atdevsoft.apps.toword.core.database.ToDo as ToDoDb
import com.atdevsoft.apps.toword.core.database.ToDoRepository
import com.atdevsoft.apps.toword.core.database.ToDoSummary
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
import java.util.*

abstract class ToDoDetailUseCase<T : ToDo, D : ToDoDb, R : ToDoRepository<D>>(
    protected val repository: R,
    protected val mapper: Mapper<D, T>
) {
    protected abstract suspend fun getItemDb(itemId: Long): D

    suspend fun delete(item: T) {
        repository.deleteItem(getItemDb(item.id))
    }

    protected fun createNewSummary(comment: String): ToDoSummary =
        ToDoSummary(Date(), Date(), false, null, if (comment.isBlank()) null else comment)

    protected fun updateSummary(summary: ToDoSummary, comment: String): ToDoSummary =
        summary.copy(updated = Date(), comment = if (comment.isBlank()) null else comment)

    suspend fun getItem(itemId: Long): T = mapper.map(getItemDb(itemId))
}

class ToWatchDetailUseCase(repository: ToWatchRepository, mapper: Mapper<ToWatchDb, ToWatch>) :
    ToDoDetailUseCase<ToWatch, ToWatchDb, ToWatchRepository>(repository, mapper) {
    override suspend fun getItemDb(itemId: Long): ToWatchDb = repository.getItemById(itemId)

    suspend fun create(title: String, isSeries: Boolean, year: Int?, comment: String): ToWatch {
        val item = ToWatchDb(0, createNewSummary(comment), title, isSeries, year)
        return mapper.map(item.copy(id = repository.insertItem(item)))
    }

    suspend fun update(
        item: ToWatch,
        title: String,
        isSeries: Boolean,
        year: Int?,
        comment: String
    ): ToWatch {
        val dbItem = getItemDb(item.id)
        val res = dbItem.copy(
            toDoSummary = updateSummary(dbItem.toDoSummary, comment),
            title = title, isSeries = isSeries, year = year
        )
        repository.updateItem(res)
        return mapper.map(res)
    }
}

class ToReadDetailUseCase(repository: ToReadRepository, mapper: Mapper<ToReadDb, ToRead>) :
    ToDoDetailUseCase<ToRead, ToReadDb, ToReadRepository>(repository, mapper) {
    override suspend fun getItemDb(itemId: Long): ToReadDb = repository.getItemById(itemId)

    suspend fun create(book: String, author: String, comment: String): ToRead {
        val item = ToReadDb(0, createNewSummary(comment), book, if (author.isBlank()) null else author)
        return mapper.map(item.copy(id = repository.insertItem(item)))
    }

    suspend fun update(
        item: ToRead,
        book: String,
        author: String,
        comment: String
    ): ToRead {
        val dbItem = getItemDb(item.id)
        val res = dbItem.copy(
            toDoSummary = updateSummary(dbItem.toDoSummary, comment),
            book = book, author = if (author.isBlank()) null else author
        )
        repository.updateItem(res)
        return mapper.map(res)
    }
}

class ToOtherDetailUseCase(repository: ToOtherRepository, mapper: Mapper<ToOtherDb, ToOther>) :
    ToDoDetailUseCase<ToOther, ToOtherDb, ToOtherRepository>(repository, mapper) {
    override suspend fun getItemDb(itemId: Long): ToOtherDb = repository.getItemById(itemId)

    suspend fun create(action: String, comment: String): ToOther {
        val item = ToOtherDb(0, createNewSummary(comment), action)
        return mapper.map(item.copy(id = repository.insertItem(item)))
    }

    suspend fun update(
        item: ToOther,
        action: String,
        comment: String
    ): ToOther {
        val dbItem = getItemDb(item.id)
        val res = dbItem.copy(
            toDoSummary = updateSummary(dbItem.toDoSummary, comment),
            action = action
        )
        repository.updateItem(res)
        return mapper.map(res)
    }
}
