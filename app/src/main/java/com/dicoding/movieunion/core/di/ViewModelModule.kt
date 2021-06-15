package com.dicoding.movieunion.core.di

import com.dicoding.movieunion.feature.detail_movie.presentation.viewmodel.MovieDetailViewModel
import com.dicoding.movieunion.feature.movie.presentation.viewmodel.MovieViewModel
import com.dicoding.movieunion.feature.movie.presentation.viewmodel.TVShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TVShowViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}