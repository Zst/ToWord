package com.atdevsoft.apps.toword.core.database

import androidx.room.ColumnInfo
import java.util.*

interface ToDo {
    val id: Long
    val toDoSummary: ToDoSummary

    /**
     * We rely on the fact that copy method returns an instance of the same class, all
     * descendants should follow that contract.
     */
    fun copy(copySummary: ToDoSummary): ToDo
}

/**
 * Base to-do information for all types of to-do records.
 */
data class ToDoSummary(
    val created: Date,
    val updated: Date,
    @ColumnInfo(name = "is_done") val isDone: Boolean,
    @ColumnInfo(name = "would_recommend") val wouldRecommend: Boolean?,
    val comment: String?)