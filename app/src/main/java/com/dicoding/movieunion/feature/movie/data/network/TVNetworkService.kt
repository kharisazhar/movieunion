package com.dicoding.movieunion.feature.movie.data.network

import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TVNetworkService {
    companion object {
        const val TV_POPULAR = "tv/popular"
    }

    @GET(TV_POPULAR)
    suspend fun getTVPopular(
        @Query("api_key") key: String
    ): Response<TVShowEntity>
}