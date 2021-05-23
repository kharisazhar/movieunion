package com.dicoding.movieunion.feature.detail_movie.data.network

import com.dicoding.movieunion.feature.detail_movie.domain.entities.MovieDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.entities.TVDetailEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailNetworkService {
    companion object {
        const val MOVIE_DETAIL = "movie/{id}"
        const val TV_DETAIL = "tv/{id}"
    }

    @GET(MOVIE_DETAIL)
    suspend fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") key: String
    ): Response<MovieDetailEntity>


    @GET(TV_DETAIL)
    suspend fun getTVDetail(
        @Path("id") id: Int,
        @Query("api_key") key: String
    ): Response<TVDetailEntity>
}