package com.atdevsoft.apps.toword.core.database.toother

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.atdevsoft.apps.toword.core.config.Config
import com.atdevsoft.apps.toword.core.database.ToDoRepository

@Dao
abstract class ToOtherRepository: ToDoRepository<ToOther> {
    /**
     * Returns full information on general to do item based on the primary key id
     */
    @Query("SELECT * FROM to_other WHERE id = :itemId")
    abstract suspend fun getItemById(itemId: Long): ToOther

    /**
     * Returns all general to do records, sorting defined by [Config.SORT_ORDER] value.
     */
    @Query("SELECT * FROM to_other ORDER BY ${Config.SORT_ORDER}")
    abstract fun getAllItemsLiveData(): LiveData<List<ToOther>>

    /**
     * Returns all general to do records, sorting defined by [Config.SORT_ORDER] value.
     */
    @Query("SELECT * FROM to_other ORDER BY ${Config.SORT_ORDER}")
    abstract suspend fun getAllItems(): List<ToOther>
}