package com.atdevsoft.apps.toword.core.model.mappers

import com.atdevsoft.apps.toword.core.database.towatch.ToWatch as ToWatchDb
import com.atdevsoft.apps.toword.core.mapper.Mapper
import com.atdevsoft.apps.toword.core.model.ToWatch

object ToWatchMapper: Mapper<ToWatchDb, ToWatch> {
    override suspend fun map(from: ToWatchDb): ToWatch {
        return ToWatch(from.id, from.toDoSummary.isDone, from.toDoSummary.comment ?: "", from.toDoSummary.wouldRecommend, from.title, from.isSeries, from.year)
    }
}