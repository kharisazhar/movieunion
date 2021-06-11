package com.dicoding.movieunion.feature.movie.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.feature.movie.data.database.MovieDao
import com.dicoding.movieunion.feature.movie.data.network.MovieNetworkService
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.repositories.MovieRepositories
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class MovieRepositoriesImpl(
    private val movieNetworkService: MovieNetworkService,
    private val movieDao: MovieDao
) :
    MovieRepositories {
    override suspend fun getMoviePopular(): Response<MovieEntity> {
        return movieNetworkService.getMoviePopular(BuildConfig.KEY_AUTH)
    }

    override suspend fun insertMoviesPopular(movies: List<MovieResult>) {
        movieDao.insertMovies(movies)
    }

    override suspend fun getMoviesFromDB(): Flow<List<MovieResult>> {
        return movieDao.getMovies()
    }

    override suspend fun getFavoriteMovie(): Flow<List<MovieResult>>? {
        return movieDao.getFavoriteMovie()
    }
}