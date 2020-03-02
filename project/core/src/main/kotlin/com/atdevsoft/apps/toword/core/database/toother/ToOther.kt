package com.atdevsoft.apps.toword.core.database.toother

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.atdevsoft.apps.toword.core.database.ToDo
import com.atdevsoft.apps.toword.core.database.ToDoSummary

/**
 * Other kind of to-do's (neither books nor films): to play, to go, etc.
 */
@Entity(tableName = "to_other")
data class ToOther(
    @PrimaryKey(autoGenerate = true) override val id: Long,
    @Embedded override val toDoSummary: ToDoSummary,
    val action: String
): ToDo