package com.dicoding.movieunion.feature.movie.data.repositories

import androidx.paging.PagingSource
import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.feature.movie.data.database.MovieDao
import com.dicoding.movieunion.feature.movie.data.network.MovieNetworkService
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.repositories.MovieRepositories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoriesImpl(
    private val movieNetworkService: MovieNetworkService,
    private val movieDao: MovieDao
) :
    MovieRepositories {
    override suspend fun getMoviePopular(): Response<MovieEntity> {
        return movieNetworkService.getMoviePopular(BuildConfig.KEY_AUTH)
    }

    override fun getFavoriteMovie(): PagingSource<Int, MovieResult> {

        return movieDao.getFavoriteMovie()
    }
}