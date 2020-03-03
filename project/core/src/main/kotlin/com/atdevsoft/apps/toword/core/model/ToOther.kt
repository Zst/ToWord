package com.atdevsoft.apps.toword.core.model

data class ToOther(
    override val id: Long,
    override val isDone: Boolean,
    override val comment: String,
    override val wouldRecommend: Boolean?,
    val action: String
): ToDo()