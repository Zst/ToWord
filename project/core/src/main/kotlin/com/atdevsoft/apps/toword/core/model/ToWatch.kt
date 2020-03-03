package com.atdevsoft.apps.toword.core.model

data class ToWatch(
    override val id: Long,
    override val isDone: Boolean,
    override val comment: String,
    override val wouldRecommend: Boolean?,
    val title: String,
    val isSeries: Boolean,
    val year: Int?
): ToDo()