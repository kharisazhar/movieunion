package com.dicoding.movieunion.feature.movie.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.core.MainCoroutineRule
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity
import com.dicoding.movieunion.feature.movie.domain.usecases.TVUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
    private val tTVShowEntity = DataDummy.generateDummyTVSHow()

    private var tvUseCase = mock(TVUseCase::class.java)

    @Mock
    private lateinit var observerTVShowEntity: Observer<TVShowEntity?>

    @Mock
    private lateinit var observerError: Observer<BaseErrorResponse?>

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
            val tvShowPopular = MutableLiveData<TVShowEntity>()
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
}