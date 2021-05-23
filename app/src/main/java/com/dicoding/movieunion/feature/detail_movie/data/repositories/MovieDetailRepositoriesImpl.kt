package com.dicoding.movieunion.feature.detail_movie.data.repositories

import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.feature.detail_movie.data.network.MovieDetailNetworkService
import com.dicoding.movieunion.feature.detail_movie.domain.entities.MovieDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.entities.TVDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.repositories.MovieDetailRepositories
import retrofit2.Response

class MovieDetailRepositoriesImpl(private val movieDetailNetworkService: MovieDetailNetworkService) :
    MovieDetailRepositories {
    override suspend fun getMovieDetail(id: Int): Response<MovieDetailEntity> {
        return movieDetailNetworkService.getMovieDetail(id, BuildConfig.KEY_AUTH)
    }

    override suspend fun getTVDetail(id: Int): Response<TVDetailEntity> {
        return movieDetailNetworkService.getTVDetail(id, BuildConfig.KEY_AUTH)
    }
}