package com.dicoding.movieunion.core.di

import androidx.room.Room
import com.dicoding.movieunion.core.database.MovieUnionDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            MovieUnionDatabase::class.java,
            "MovieUnion.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<MovieUnionDatabase>().movieDao() }
}
