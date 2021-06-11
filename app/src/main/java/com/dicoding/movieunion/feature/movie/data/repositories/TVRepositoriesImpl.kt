package com.dicoding.movieunion.feature.movie.data.repositories

import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.feature.movie.data.database.TVShowDao
import com.dicoding.movieunion.feature.movie.data.network.TVNetworkService
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.domain.repositories.TVRepositories
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class TVRepositoriesImpl(
    private val tvNetworkService: TVNetworkService,
    private val tvShowDao: TVShowDao
) : TVRepositories {
    override suspend fun getTVPopular(): Response<TVShowEntity> {
        return tvNetworkService.getTVPopular(BuildConfig.KEY_AUTH)
    }

    override suspend fun insertTVShow(tvShow: TVShowResult) {
        tvShowDao.insertFavoriteTVShow(tvShow)
    }

    override suspend fun getFavoriteTVShows(): Flow<List<TVShowResult>>? {
        return tvShowDao.getFavoriteTVShows()
    }
}