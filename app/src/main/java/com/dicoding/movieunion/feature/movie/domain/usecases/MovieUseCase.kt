package com.dicoding.movieunion.feature.movie.domain.usecases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.core.utils.EspressoIdlingResource
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.repositories.MovieRepositories
import kotlinx.coroutines.flow.Flow

class MovieUseCase(private val movieRepositories: MovieRepositories) {
    suspend fun getMovies(): Either<List<MovieResult>?, BaseErrorResponse> {
        EspressoIdlingResource.increment()
        try {
            val responseMovies = movieRepositories.getMoviePopular()
            return if (responseMovies.isSuccessful) {
                EspressoIdlingResource.decrement()
                Either.Left(responseMovies.body()?.movieResults)
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


    fun getFavoriteMovie(): Flow<PagingData<MovieResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                movieRepositories.getFavoriteMovie()
            }
        ).flow
    }
}
