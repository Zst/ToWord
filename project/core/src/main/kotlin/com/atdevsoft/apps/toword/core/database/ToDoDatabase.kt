package com.atdevsoft.apps.toword.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.atdevsoft.apps.toword.core.config.Config
import com.atdevsoft.apps.toword.core.database.converters.DateConverter
import com.atdevsoft.apps.toword.core.database.toother.ToOther
import com.atdevsoft.apps.toword.core.database.toother.ToOtherRepository
import com.atdevsoft.apps.toword.core.database.toread.ToRead
import com.atdevsoft.apps.toword.core.database.toread.ToReadRepository
import com.atdevsoft.apps.toword.core.database.towatch.ToWatch
import com.atdevsoft.apps.toword.core.database.towatch.ToWatchRepository

@Database(
    entities = [ToWatch::class, ToRead::class, ToOther::class],
    exportSchema = Config.DATABASE_EXPORT_SCHEMA,
    version = Config.DATABASE_VERSION
)
@TypeConverters(DateConverter::class)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun getToWatchRepository(): ToWatchRepository
    abstract fun getToReadRepository(): ToReadRepository
    abstract fun getToOtherRepository(): ToOtherRepository
}
