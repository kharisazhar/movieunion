package com.dicoding.movieunion.feature.movie.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagingData
import com.dicoding.core.MainCoroutineRule
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.domain.usecases.TVUseCase
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var tvViewModel: TVShowViewModel
    private val tTVShowEntity = DataDummy.generateDummyTVSHow().tvShowResult

    private var tvUseCase = mock(TVUseCase::class.java)

    @Mock
    private lateinit var observerTVShowEntity: Observer<List<TVShowResult>?>

    @Mock
    private lateinit var observerError: Observer<BaseErrorResponse?>

    @Mock
    private lateinit var observerFavoriteTVShows: Observer<List<TVShowResult>?>

    private var tBaseErrorResponse = BaseErrorResponse(
        400,
        "",
        false
    )

    @Before
    fun setup() {
        tvViewModel = TVShowViewModel(tvUseCase)
    }

    @Test
    fun `should get movie success`() {
        runBlocking {
            val tvShowPopular = MutableLiveData<List<TVShowResult>>()
            tvShowPopular.value = tTVShowEntity
            Mockito.`when`(tvUseCase.getTVPopular()).thenReturn(Either.Left(tTVShowEntity))
            tvViewModel.getTVPopular()
            tvViewModel.tvPopular.observeForever(observerTVShowEntity)
            Mockito.verify(observerTVShowEntity).onChanged(tTVShowEntity)
        }
    }

    @Test
    fun `should get movie error`() {
        runBlocking {
            val error = MutableLiveData<BaseErrorResponse>()
            error.value = tBaseErrorResponse
            Mockito.`when`(tvUseCase.getTVPopular()).thenReturn(
                Either.Right(
                    tBaseErrorResponse
                )
            )
            tvViewModel.getTVPopular()
            tvViewModel.error.observeForever(observerError)
            Mockito.verify(observerError).onChanged(tBaseErrorResponse)
        }
    }

    @Test
    fun `should get tv show favorite`() {
        runBlocking {

            val dummyTVShow = DataDummy.generateDummyTVSHow().tvShowResult
            val pagingData = PagingData.from(dummyTVShow)
            val flow = flow {
                emit(pagingData)
            }

            Mockito.`when`(tvUseCase.getFavoriteTVShow()).thenReturn(flow)
            tvViewModel.getFavoriteTVShows().collect {
                assertEquals(it, pagingData)
            }
        }
    }
}