package com.dicoding.movieunion.feature.movie.domain.repositories

import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import retrofit2.Response

interface MovieRepositories {
    suspend fun getMoviePopular(): Response<MovieEntity>
}