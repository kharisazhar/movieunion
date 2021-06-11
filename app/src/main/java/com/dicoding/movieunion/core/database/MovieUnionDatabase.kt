package com.dicoding.movieunion.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dicoding.movieunion.core.utils.TypeConverter
import com.dicoding.movieunion.feature.movie.data.database.MovieDao
import com.dicoding.movieunion.feature.movie.data.database.TVShowDao
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult

@Database(
    entities = [MovieResult::class, TVShowResult::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [TypeConverter::class])
abstract class MovieUnionDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TVShowDao
}