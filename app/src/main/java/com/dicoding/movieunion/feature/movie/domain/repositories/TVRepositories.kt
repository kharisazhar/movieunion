package com.dicoding.movieunion.feature.movie.domain.repositories

import androidx.paging.PagingSource
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface TVRepositories {
    suspend fun getTVPopular(): Response<TVShowEntity>
    suspend fun insertTVShow(tvShow: TVShowResult)
    fun getFavoriteTVShows(): PagingSource<Int, TVShowResult>
}