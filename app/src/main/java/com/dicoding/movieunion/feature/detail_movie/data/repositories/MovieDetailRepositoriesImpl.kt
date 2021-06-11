package com.dicoding.movieunion.feature.detail_movie.data.repositories

import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.feature.detail_movie.data.network.MovieDetailNetworkService
import com.dicoding.movieunion.feature.detail_movie.domain.entities.MovieDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.entities.TVDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.repositories.MovieDetailRepositories
import com.dicoding.movieunion.feature.movie.data.database.MovieDao
import com.dicoding.movieunion.feature.movie.data.database.TVShowDao
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import retrofit2.Response

class MovieDetailRepositoriesImpl(
    private val movieDetailNetworkService: MovieDetailNetworkService,
    private val movieDao: MovieDao,
    private val tvShowDao: TVShowDao
) :
    MovieDetailRepositories {
    override suspend fun getMovieDetail(id: Int): Response<MovieDetailEntity> {
        return movieDetailNetworkService.getMovieDetail(id, BuildConfig.KEY_AUTH)
    }

    override suspend fun getTVDetail(id: Int): Response<TVDetailEntity> {
        return movieDetailNetworkService.getTVDetail(id, BuildConfig.KEY_AUTH)
    }

    override suspend fun insertFavoriteMovie(movie: MovieResult) {
        movieDao.insertFavoriteMovie(movie)
    }

    override suspend fun deleteFavoriteMovie(id: Int) {
        movieDao.deleteFavoriteMovie(id)
    }

    override suspend fun insertFavoriteTVShow(tvShow: TVShowResult) {
        tvShowDao.insertFavoriteTVShow(tvShow)
    }

    override suspend fun deleteFavoriteTVShow(id: Int) {
        tvShowDao.deleteFavoriteTVShow(id)
    }
}