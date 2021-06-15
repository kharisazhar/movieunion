package com.dicoding.movieunion.feature.movie.domain.repositories

import androidx.paging.PagingSource
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import retrofit2.Response

interface MovieRepositories {
    suspend fun getMoviePopular(): Response<MovieEntity>
    fun getFavoriteMovie(): PagingSource<Int, MovieResult>
}