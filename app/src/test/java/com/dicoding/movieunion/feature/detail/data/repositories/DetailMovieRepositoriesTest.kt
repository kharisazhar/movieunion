package com.dicoding.movieunion.feature.detail.data.repositories

import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.feature.detail_movie.data.network.MovieDetailNetworkService
import com.dicoding.movieunion.feature.detail_movie.data.repositories.MovieDetailRepositoriesImpl
import com.dicoding.movieunion.feature.detail_movie.domain.repositories.MovieDetailRepositories
import com.dicoding.movieunion.feature.movie.data.database.MovieDao
import com.dicoding.movieunion.feature.movie.data.database.TVShowDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Response

class DetailMovieRepositoriesTest {

    private var movieDetailNetworkService = Mockito.mock(MovieDetailNetworkService::class.java)
    private var movieDao = Mockito.mock(MovieDao::class.java)
    private var tvShowDao = Mockito.mock(TVShowDao::class.java)

    private lateinit var movieDetailRepositories: MovieDetailRepositories

    private val tMovieDetailEntity = DataDummy.generateDummyMovieDetail()
    private val tTVDetailEntity = DataDummy.generateDummyTVDetail()

    @Before
    fun setUp() {
        movieDetailRepositories =
            MovieDetailRepositoriesImpl(movieDetailNetworkService, movieDao, tvShowDao)
    }

    @Test
    fun `should success get detail movies`() {
        runBlocking {
            Mockito.`when`(movieDetailNetworkService.getMovieDetail(1, BuildConfig.KEY_AUTH))
                .thenReturn(
                    Response.success(
                        200,
                        tMovieDetailEntity
                    )
                )
            val result = movieDetailRepositories.getMovieDetail(1)
            Assert.assertEquals(result.body(), tMovieDetailEntity)
        }
    }

    @Test
    fun `should success get detail TV`() {
        runBlocking {
            Mockito.`when`(movieDetailNetworkService.getTVDetail(1, BuildConfig.KEY_AUTH))
                .thenReturn(
                    Response.success(
                        200,
                        tTVDetailEntity
                    )
                )
            val result = movieDetailRepositories.getTVDetail(1)
            Assert.assertEquals(result.body(), tTVDetailEntity)
        }
    }
}