package com.dicoding.movieunion.feature.movie.data.network

import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieNetworkService {
    companion object {
        const val MOVIE_POPULAR = "movie/popular"
    }

    @GET(MOVIE_POPULAR)
    suspend fun getMoviePopular(
        @Query("api_key") key: String
    ): Response<MovieEntity>
}