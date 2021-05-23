package com.dicoding.movieunion.feature.movie.data.repositories

import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.feature.movie.data.network.MovieNetworkService
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import com.dicoding.movieunion.feature.movie.domain.repositories.MovieRepositories
import retrofit2.Response

class MovieRepositoriesImpl(private val movieNetworkService: MovieNetworkService) :
    MovieRepositories {
    override suspend fun getMoviePopular(): Response<MovieEntity> {
        return movieNetworkService.getMoviePopular(BuildConfig.KEY_AUTH)
    }
}