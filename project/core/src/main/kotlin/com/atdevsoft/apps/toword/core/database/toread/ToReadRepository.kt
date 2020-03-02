package com.atdevsoft.apps.toword.core.database.toread

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.atdevsoft.apps.toword.core.config.Config
import com.atdevsoft.apps.toword.core.database.ToDoRepository

@Dao
abstract class ToReadRepository: ToDoRepository<ToRead> {
    /**
     * Returns full information on to read item based on the primary key id
     */
    @Query("SELECT * FROM to_read WHERE id = :itemId")
    abstract suspend fun getItemById(itemId: Long): ToRead

    /**
     * Returns all to read records, sorting defined by [Config.SORT_ORDER] value
     */
    @Query("SELECT * FROM to_read ORDER BY ${Config.SORT_ORDER}")
    abstract fun getAllItemsLiveData(): LiveData<List<ToRead>>

    /**
     * Returns all to read records, sorting defined by [Config.SORT_ORDER] value
     */
    @Query("SELECT * FROM to_read ORDER BY ${Config.SORT_ORDER}")
    abstract suspend fun getAllItems(): List<ToRead>
}