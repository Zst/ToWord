package com.atdevsoft.apps.toword.core.model

data class ToRead(
    override val id: Long,
    override val isDone: Boolean,
    override val comment: String,
    override val wouldRecommend: Boolean?,
    val book: String,
    val author: String
): ToDo()