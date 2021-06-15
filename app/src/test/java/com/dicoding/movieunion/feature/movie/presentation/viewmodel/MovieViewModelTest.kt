package com.dicoding.movieunion.feature.movie.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagingData
import com.dicoding.core.MainCoroutineRule
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.usecases.MovieUseCase
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
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var movieViewModel: MovieViewModel
    private val tMovieEntity = DataDummy.generateDummyMovie().movieResults

    private var movieUseCase = mock(MovieUseCase::class.java)

    @Mock
    private lateinit var observerMovieEntity: Observer<List<MovieResult>?>

    @Mock
    private lateinit var observerError: Observer<BaseErrorResponse?>

    private var tBaseErrorResponse = BaseErrorResponse(
        400,
        "",
        false
    )

    @Before
    fun setup() {
        movieViewModel = MovieViewModel(movieUseCase)
    }

    @Test
    fun `should get movie success`() {
        runBlocking {
            val movies = MutableLiveData<List<MovieResult>>()
            movies.value = tMovieEntity
            `when`(movieUseCase.getMovies()).thenReturn(Either.Left(tMovieEntity))
            movieViewModel.getMovies()
            movieViewModel.movie.observeForever(observerMovieEntity)
            verify(observerMovieEntity).onChanged(tMovieEntity)
        }
    }

    @Test
    fun `should get movie error`() {
        runBlocking {
            val error = MutableLiveData<BaseErrorResponse>()
            error.value = tBaseErrorResponse
            `when`(movieUseCase.getMovies()).thenReturn(
                Either.Right(
                    tBaseErrorResponse
                )
            )
            movieViewModel.getMovies()
            movieViewModel.error.observeForever(observerError)
            verify(observerError).onChanged(tBaseErrorResponse)
        }
    }

    @Test
    fun `should get movie favorite`() {

        runBlocking {

            val dummyMovie = DataDummy.generateDummyMovie().movieResults
            val pagingData = PagingData.from(dummyMovie)
            val flow = flow {
                emit(pagingData)
            }

            `when`(movieUseCase.getFavoriteMovie()).thenReturn(flow)
            movieViewModel.getFavoriteMovie().collect {
                assertEquals(it, pagingData)
            }
        }
    }
}