package com.atdevsoft.apps.toword.core.mapper

interface Mapper<F, T> {
    suspend fun map(from: F): T
}
