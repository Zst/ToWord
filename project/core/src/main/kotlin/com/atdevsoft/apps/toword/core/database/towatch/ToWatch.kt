package com.atdevsoft.apps.toword.core.database.towatch

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.atdevsoft.apps.toword.core.database.ToDo
import com.atdevsoft.apps.toword.core.database.ToDoSummary

/**
 * Watch (film, series) to-do item
 */
@Entity(tableName = "to_watch")
data class ToWatch(
    @PrimaryKey(autoGenerate = true) override val id: Long,
    @Embedded override val toDoSummary: ToDoSummary,
    val title: String,
    val isSeries: Boolean,
    val year: Int?
): ToDo