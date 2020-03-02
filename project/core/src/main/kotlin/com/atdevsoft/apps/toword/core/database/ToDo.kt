package com.atdevsoft.apps.toword.core.database

import androidx.room.ColumnInfo
import java.util.*

interface ToDo {
    val id: Long
    val toDoSummary: ToDoSummary
}

/**
 * Base to-do information for all types of to-do records.
 */
data class ToDoSummary(
    val created: Date,
    val updated: Date,
    val done: Boolean,
    @ColumnInfo(name = "would_recommend") val wouldRecommend: Boolean?,
    val comment: String?)