package com.dicoding.movieunion.feature.movie.data.repositories

import androidx.paging.PagingSource
import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.core.utils.PagingSourceUtils
import com.dicoding.movieunion.feature.movie.data.database.MovieDao
import com.dicoding.movieunion.feature.movie.data.network.MovieNetworkService
import com.dicoding.movieunion.feature.movie.domain.repositories.MovieRepositories
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Response

class MovieRepositoriesTest {

    private var movieNetworkService = mock(MovieNetworkService::class.java)
    private var movieDao = mock(MovieDao::class.java)

    private lateinit var movieRepositories: MovieRepositories

    private val tMovieEntity = DataDummy.generateDummyMovie()

    @Before
    fun setUp() {
        movieRepositories = MovieRepositoriesImpl(movieNetworkService, movieDao)
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

    @Test
    fun `should success get favorite movies`() {
        runBlocking {
            val tData = PagingSourceUtils(DataDummy.generateDummyMovie().movieResults)
            `when`(movieDao.getFavoriteMovie()).thenReturn(tData)

            val data = movieRepositories.getFavoriteMovie().load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 5,
                    placeholdersEnabled = false
                )
            )

            val actual = tData.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 5,
                    placeholdersEnabled = false
                )
            )

            assertNotNull(actual)
            assertNotNull(data)
            assertEquals(actual, data)
        }
    }
}