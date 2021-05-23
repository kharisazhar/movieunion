package com.dicoding.movieunion.feature.movie.data.repositories

import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.feature.movie.data.network.MovieNetworkService
import com.dicoding.movieunion.feature.movie.domain.repositories.MovieRepositories
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Response

class MovieRepositoriesTest {

    private var movieNetworkService = mock(MovieNetworkService::class.java)

    private lateinit var movieRepositories: MovieRepositories

    private val tMovieEntity = DataDummy.generateDummyMovie()

    @Before
    fun setUp() {
        movieRepositories = MovieRepositoriesImpl(movieNetworkService)
    }

    @Test
    fun `should success get movies`() {
        runBlocking {
            `when`(movieNetworkService.getMoviePopular(BuildConfig.KEY_AUTH)).thenReturn(
                Response.success(
                    200,
                    tMovieEntity
                )
            )
            val result = movieRepositories.getMoviePopular()
            assertEquals(result.body(), tMovieEntity)
        }
    }
}