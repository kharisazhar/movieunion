package com.dicoding.movieunion.feature.detail_movie.domain.repositories

import com.dicoding.movieunion.feature.detail_movie.domain.entities.MovieDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.entities.TVDetailEntity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import retrofit2.Response

interface MovieDetailRepositories {
    suspend fun getMovieDetail(id: Int): Response<MovieDetailEntity>
    suspend fun getTVDetail(id: Int): Response<TVDetailEntity>
}