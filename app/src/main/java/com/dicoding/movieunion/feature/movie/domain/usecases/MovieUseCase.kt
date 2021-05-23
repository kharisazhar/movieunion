package com.dicoding.movieunion.feature.movie.domain.usecases

import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.core.utils.EspressoIdlingResource
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import com.dicoding.movieunion.feature.movie.domain.repositories.MovieRepositories

class MovieUseCase(private val movieRepositories: MovieRepositories) {
    suspend fun getMovies(): Either<MovieEntity, BaseErrorResponse> {
        EspressoIdlingResource.increment()
        try {
            val responseMovies = movieRepositories.getMoviePopular()
            return if (responseMovies.isSuccessful) {
                EspressoIdlingResource.decrement()
                Either.Left(responseMovies.body()!!)
            } else {
                EspressoIdlingResource.decrement()
                Either.Right(
                    BaseErrorResponse(
                        statusCode = responseMovies.code(),
                        statusMessage = responseMovies.message(),
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
}