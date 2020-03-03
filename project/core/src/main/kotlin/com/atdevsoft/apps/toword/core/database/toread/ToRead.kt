package com.atdevsoft.apps.toword.core.database.toread

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.atdevsoft.apps.toword.core.database.ToDo
import com.atdevsoft.apps.toword.core.database.ToDoSummary

/**
 * Read to-do item
 */
@Entity(tableName = "to_read")
data class ToRead(
    @PrimaryKey(autoGenerate = true) override val id: Long,
    @Embedded override val toDoSummary: ToDoSummary,
    val book: String,
    val author: String?
): ToDo {
    override fun copy(copySummary: ToDoSummary): ToDo = copy(toDoSummary = copySummary)
}