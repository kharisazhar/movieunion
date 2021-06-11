package com.dicoding.movieunion.feature.detail_movie.domain.usecases

import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.core.utils.EspressoIdlingResource
import com.dicoding.movieunion.feature.detail_movie.domain.entities.MovieDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.entities.TVDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.repositories.MovieDetailRepositories
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult

class MovieDetailUseCase(private val movieDetailRepositories: MovieDetailRepositories) {
    suspend fun getMovieDetail(id: Int): Either<MovieDetailEntity, BaseErrorResponse> {
        EspressoIdlingResource.increment()
        try {
            val response = movieDetailRepositories.getMovieDetail(id)
            return if (response.isSuccessful) {
                EspressoIdlingResource.decrement()
                Either.Left(response.body()!!)
            } else {
                EspressoIdlingResource.decrement()
                Either.Right(
                    BaseErrorResponse(
                        statusCode = response.code(),
                        statusMessage = response.message(),
                        success = false
                    )
                )
            }
        } catch (e: Exception) {
            EspressoIdlingResource.decrement()
            return Either.Right(
                BaseErrorResponse(
                    statusCode = 505,
                    statusMessage = "Oops something went wrong ${e.message}",
                    success = false
                )
            )
        }
    }

    suspend fun getTVDetail(id: Int): Either<TVDetailEntity, BaseErrorResponse> {
        EspressoIdlingResource.increment()
        try {
            val response = movieDetailRepositories.getTVDetail(id)
            return if (response.isSuccessful) {
                EspressoIdlingResource.decrement()
                Either.Left(response.body()!!)
            } else {
                EspressoIdlingResource.decrement()
                Either.Right(
                    BaseErrorResponse(
                        statusCode = response.code(),
                        statusMessage = response.message(),
                        success = false
                    )
                )
            }
        } catch (e: Exception) {
            EspressoIdlingResource.decrement()
            return Either.Right(
                BaseErrorResponse(
                    statusCode = 505,
                    statusMessage = "Oops something went wrong ${e.message}",
                    success = false
                )
            )
        }
    }

    suspend fun insertFavoriteMovie(movie: MovieResult) {
        movieDetailRepositories.insertFavoriteMovie(movie)
    }

    suspend fun deleteFavoriteMovie(id: Int) {
        try {
            movieDetailRepositories.deleteFavoriteMovie(id)
        } catch (e: Exception) {

        }
    }

    suspend fun insertFavoriteTVShow(tvShow: TVShowResult) {
        movieDetailRepositories.insertFavoriteTVShow(tvShow)
    }

    suspend fun deleteFavoriteTVShow(id: Int) {
        try {
            movieDetailRepositories.deleteFavoriteTVShow(id)
        } catch (e: Exception) {

        }
    }
}