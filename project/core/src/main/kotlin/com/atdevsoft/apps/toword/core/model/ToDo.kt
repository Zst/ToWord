package com.atdevsoft.apps.toword.core.model

abstract class ToDo {
    abstract val id: Long
    abstract val isDone: Boolean
    abstract val comment: String
    abstract val wouldRecommend: Boolean?

    abstract override fun equals(other: Any?): Boolean
    abstract override fun hashCode(): Int
}