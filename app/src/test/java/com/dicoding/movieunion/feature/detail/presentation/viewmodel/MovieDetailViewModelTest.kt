package com.dicoding.movieunion.feature.detail.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.core.MainCoroutineRule
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.feature.detail_movie.domain.entities.MovieDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.entities.TVDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.usecases.MovieDetailUseCase
import com.dicoding.movieunion.feature.detail_movie.presentation.viewmodel.MovieDetailViewModel
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var movieDetailViewModel: MovieDetailViewModel
    private val tMovieDetailEntity = DataDummy.generateDummyMovieDetail()
    private val tTVDetailEntity = DataDummy.generateDummyTVDetail()

    private var movieDetailUseCase = Mockito.mock(MovieDetailUseCase::class.java)

    @Mock
    private lateinit var observerMovieDetailEntity: Observer<MovieDetailEntity?>

    @Mock
    private lateinit var observerTVDetailEntity: Observer<TVDetailEntity?>

    @Mock
    private lateinit var observerMovieError: Observer<BaseErrorResponse?>

    @Mock
    private lateinit var observerTVError: Observer<BaseErrorResponse?>

    private var tBaseErrorResponse = BaseErrorResponse(
        400,
        "",
        false
    )

    @Before
    fun setup() {
        movieDetailViewModel = MovieDetailViewModel(movieDetailUseCase)
    }

    @Test
    fun `should get movie detail success`() {
        runBlocking {
            val movie = MutableLiveData<MovieDetailEntity>()
            movie.value = tMovieDetailEntity
            `when`(movieDetailUseCase.getMovieDetail(1))
                .thenReturn(Either.Left(tMovieDetailEntity))
            movieDetailViewModel.getMovieDetail(1)
            movieDetailViewModel.movieDetail.observeForever(observerMovieDetailEntity)
            verify(observerMovieDetailEntity).onChanged(tMovieDetailEntity)
        }
    }

    @Test
    fun `should get movie detail error`() {
        runBlocking {
            val error = MutableLiveData<BaseErrorResponse>()
            error.value = tBaseErrorResponse
            `when`(movieDetailUseCase.getMovieDetail(1)).thenReturn(
                Either.Right(
                    tBaseErrorResponse
                )
            )
            movieDetailViewModel.getMovieDetail(1)
            movieDetailViewModel.errorDetailMovie.observeForever(observerMovieError)
            verify(observerMovieError).onChanged(tBaseErrorResponse)
        }
    }

    @Test
    fun `should get TV detail success`() {
        runBlocking {
            val tvShow = MutableLiveData<TVDetailEntity>()
            tvShow.value = tTVDetailEntity
            `when`(movieDetailUseCase.getTVDetail(1))
                .thenReturn(Either.Left(tTVDetailEntity))
            movieDetailViewModel.getTVDetail(1)
            movieDetailViewModel.tvDetail.observeForever(observerTVDetailEntity)
            verify(observerTVDetailEntity).onChanged(tTVDetailEntity)
        }
    }

    @Test
    fun `should get TV detail error`() {
        runBlocking {
            val error = MutableLiveData<BaseErrorResponse>()
            error.value = tBaseErrorResponse
            `when`(movieDetailUseCase.getTVDetail(1)).thenReturn(
                Either.Right(
                    tBaseErrorResponse
                )
            )
            movieDetailViewModel.getTVDetail(1)
            movieDetailViewModel.errorDetailTV.observeForever(observerTVError)
            verify(observerTVError).onChanged(tBaseErrorResponse)
        }
    }
}