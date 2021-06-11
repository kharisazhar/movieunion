package com.dicoding.movieunion.feature.movie.domain.repositories

import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface TVRepositories {
    suspend fun getTVPopular(): Response<TVShowEntity>
    suspend fun insertTVShow(tvShow: TVShowResult)
    suspend fun getFavoriteTVShows(): Flow<List<TVShowResult>>?
}