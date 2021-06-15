package com.dicoding.movieunion.core.di

import com.dicoding.movieunion.core.network.ApiConfig
import com.dicoding.movieunion.feature.detail_movie.data.network.MovieDetailNetworkService
import com.dicoding.movieunion.feature.movie.data.network.MovieNetworkService
import com.dicoding.movieunion.feature.movie.data.network.TVNetworkService
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single { ApiConfig.retrofitService() }
    factory { provideMovieNetworkService(get()) }
    factory { provideTVNetworkService(get()) }
    factory { provideDetailMovieNetworkService(get()) }

}

fun provideMovieNetworkService(retrofit: Retrofit): MovieNetworkService =
    retrofit.create(MovieNetworkService::class.java)

fun provideTVNetworkService(retrofit: Retrofit): TVNetworkService =
    retrofit.create(TVNetworkService::class.java)

fun provideDetailMovieNetworkService(retrofit: Retrofit): MovieDetailNetworkService =
    retrofit.create(MovieDetailNetworkService::class.java)