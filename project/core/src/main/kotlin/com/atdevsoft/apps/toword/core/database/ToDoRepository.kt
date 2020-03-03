package com.atdevsoft.apps.toword.core.database

import androidx.room.*

interface ToDoRepository<T: ToDo> {
    @Insert
    suspend fun insertItem(item: T): Long

    @Update
    suspend fun updateItem(item: T)

    @Delete
    suspend fun deleteItem(item: T)
}
