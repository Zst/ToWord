package com.atdevsoft.apps.toword.core.database.towatch

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.atdevsoft.apps.toword.core.config.Config
import com.atdevsoft.apps.toword.core.database.ToDoRepository

@Dao
abstract class ToWatchRepository: ToDoRepository<ToWatch> {
    /**
     * Returns full information on to read item based on the primary key id
     */
    @Query("SELECT * FROM to_watch WHERE id = :itemId")
    abstract suspend fun getItemById(itemId: Long): ToWatch

    /**
     * Returns all to watch records, sorting defined by [Config.SORT_ORDER] value.
     */
    @Query("SELECT * FROM to_watch ORDER BY ${Config.SORT_ORDER}")
    abstract fun getAllItemsLiveData(): LiveData<List<ToWatch>>

    /**
     * Returns all to watch records, sorting defined by [Config.SORT_ORDER] value.
     */
    @Query("SELECT * FROM to_watch ORDER BY ${Config.SORT_ORDER}")
    abstract suspend fun getAllItems(): List<ToWatch>
}