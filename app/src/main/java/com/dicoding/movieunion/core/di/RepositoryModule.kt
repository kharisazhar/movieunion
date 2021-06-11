package com.dicoding.movieunion.core.di

import com.dicoding.movieunion.feature.detail_movie.data.repositories.MovieDetailRepositoriesImpl
import com.dicoding.movieunion.feature.detail_movie.domain.repositories.MovieDetailRepositories
import com.dicoding.movieunion.feature.movie.data.repositories.MovieRepositoriesImpl
import com.dicoding.movieunion.feature.movie.data.repositories.TVRepositoriesImpl
import com.dicoding.movieunion.feature.movie.domain.repositories.MovieRepositories
import com.dicoding.movieunion.feature.movie.domain.repositories.TVRepositories
import org.koin.dsl.module

val repositoryModule = module {
    factory<MovieRepositories> { MovieRepositoriesImpl(get(), get()) }
    factory<TVRepositories> { TVRepositoriesImpl(get()) }
    factory<MovieDetailRepositories> { MovieDetailRepositoriesImpl(get(), get()) }
}