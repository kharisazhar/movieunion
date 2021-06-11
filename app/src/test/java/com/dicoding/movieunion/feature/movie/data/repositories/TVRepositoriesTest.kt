package com.dicoding.movieunion.feature.movie.data.repositories

import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.feature.movie.data.database.TVShowDao
import com.dicoding.movieunion.feature.movie.data.network.TVNetworkService
import com.dicoding.movieunion.feature.movie.domain.repositories.TVRepositories
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import retrofit2.Response

class TVRepositoriesTest {

    private var tvNetworkService = mock(TVNetworkService::class.java)
    private var tvShowDao = mock(TVShowDao::class.java)

    private lateinit var tvRepositories: TVRepositories

    private val tTVShowEntity = DataDummy.generateDummyTVSHow()

    @Before
    fun setUp() {
        tvRepositories = TVRepositoriesImpl(tvNetworkService, tvShowDao)
    }

    @Test
    fun `should success get TV Popular`() {
        runBlocking {
            Mockito.`when`(tvNetworkService.getTVPopular(BuildConfig.KEY_AUTH)).thenReturn(
                Response.success(
                    200,
                    tTVShowEntity
                )
            )
            val result = tvRepositories.getTVPopular()
            Assert.assertEquals(result.body(), tTVShowEntity)
        }
    }
}