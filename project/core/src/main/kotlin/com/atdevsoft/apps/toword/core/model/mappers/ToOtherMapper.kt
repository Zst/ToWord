package com.atdevsoft.apps.toword.core.model.mappers

import com.atdevsoft.apps.toword.core.database.toother.ToOther as ToOtherDb
import com.atdevsoft.apps.toword.core.mapper.Mapper
import com.atdevsoft.apps.toword.core.model.ToOther

object ToOtherMapper: Mapper<ToOtherDb, ToOther> {
    override suspend fun map(from: ToOtherDb): ToOther {
        return ToOther(from.id, from.toDoSummary.isDone, from.toDoSummary.comment ?: "", from.toDoSummary.wouldRecommend, from.action)
    }
}