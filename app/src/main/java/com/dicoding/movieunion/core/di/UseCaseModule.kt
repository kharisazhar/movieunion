package com.dicoding.movieunion.core.di

import com.dicoding.movieunion.feature.detail_movie.domain.usecases.MovieDetailUseCase
import com.dicoding.movieunion.feature.movie.domain.usecases.MovieUseCase
import com.dicoding.movieunion.feature.movie.domain.usecases.TVUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { MovieUseCase(get()) }
    single { TVUseCase(get()) }
    single { MovieDetailUseCase(get()) }
}