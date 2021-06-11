package com.dicoding.movieunion.feature.movie.domain.usecases

import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.core.utils.EspressoIdlingResource
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.domain.repositories.TVRepositories
import kotlinx.coroutines.flow.Flow

class TVUseCase(private val tvRepositories: TVRepositories) {
    suspend fun getTVPopular(): Either<List<TVShowResult>?, BaseErrorResponse> {
        EspressoIdlingResource.increment()
        try {
            val responseMovies = tvRepositories.getTVPopular()
            return if (responseMovies.isSuccessful) {
                EspressoIdlingResource.decrement()
                Either.Left(responseMovies.body()?.tvShowResult)
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

    suspend fun getFavoriteTVShow(): Flow<List<TVShowResult>>? {
        return tvRepositories.getFavoriteTVShows()
    }
}