package com.atdevsoft.apps.toword.core.model.mappers

import com.atdevsoft.apps.toword.core.database.toread.ToRead as ToReadDb
import com.atdevsoft.apps.toword.core.mapper.Mapper
import com.atdevsoft.apps.toword.core.model.ToRead

object ToReadMapper: Mapper<ToReadDb, ToRead> {
    override suspend fun map(from: ToReadDb): ToRead {
        return ToRead(from.id, from.toDoSummary.isDone, from.toDoSummary.comment ?: "", from.toDoSummary.wouldRecommend, from.book, from.author ?: "")
    }
}