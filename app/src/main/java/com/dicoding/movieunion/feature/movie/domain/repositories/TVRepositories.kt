package com.dicoding.movieunion.feature.movie.domain.repositories

import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity
import retrofit2.Response

interface TVRepositories {
    suspend fun getTVPopular(): Response<TVShowEntity>
}