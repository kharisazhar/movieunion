package com.dicoding.movieunion.feature.movie.domain.repositories

import androidx.lifecycle.LiveData
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieRepositories {
    suspend fun getMoviePopular(): Response<MovieEntity>
    suspend fun insertMoviesPopular(movies: List<MovieResult>)
    suspend fun getMoviesFromDB(): Flow<List<MovieResult>>
    suspend fun getFavoriteMovie(): Flow<List<MovieResult>>?
}