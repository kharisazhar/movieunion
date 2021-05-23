package com.dicoding.movieunion.feature.movie.data.repositories

import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.feature.movie.data.network.TVNetworkService
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity
import com.dicoding.movieunion.feature.movie.domain.repositories.TVRepositories
import retrofit2.Response

class TVRepositoriesImpl(private val tvNetworkService: TVNetworkService) : TVRepositories {
    override suspend fun getTVPopular(): Response<TVShowEntity> {
        return tvNetworkService.getTVPopular(BuildConfig.KEY_AUTH)
    }
}