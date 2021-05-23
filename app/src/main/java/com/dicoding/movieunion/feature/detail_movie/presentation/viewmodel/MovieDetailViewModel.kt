package com.dicoding.movieunion.feature.detail_movie.presentation.viewmodel

import androidx.lifecycle.*
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.feature.detail_movie.domain.entities.MovieDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.entities.TVDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.usecases.MovieDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface MovieDetailViewModelContract {
    fun getMovieDetail(id: Int)
    fun setMovieDetailId(id: Int)
    fun getTVDetail(id: Int)
    fun setTVDetailId(id: Int)
}

class MovieDetailViewModel(private var movieDetailUseCase: MovieDetailUseCase) : ViewModel(),
    MovieDetailViewModelContract {

    private val _movieDetailId = MutableLiveData<Int>()
    private val _movieDetail = MediatorLiveData<MovieDetailEntity?>()
    val movieDetail: LiveData<MovieDetailEntity?>
        get() = _movieDetail

    private val _tvDetailId = MutableLiveData<Int>()
    private val _tvDetail = MediatorLiveData<TVDetailEntity?>()
    val tvDetail: LiveData<TVDetailEntity?>
        get() = _tvDetail


    private val _errorDetailMovie = MediatorLiveData<BaseErrorResponse?>()
    val errorDetailMovie: LiveData<BaseErrorResponse?>
        get() = _errorDetailMovie

    private val _errorDetailTV = MediatorLiveData<BaseErrorResponse?>()
    val errorDetailTV: LiveData<BaseErrorResponse?>
        get() = _errorDetailTV

    init {
        _movieDetail.addSource(_movieDetailId) {
            getMovieDetail(it)
        }
        _tvDetail.addSource(_tvDetailId) {
            getTVDetail(it)
        }
    }

    override fun setMovieDetailId(id: Int) {
        _movieDetailId.postValue(id)
    }

    override fun getMovieDetail(id: Int) {
        viewModelScope.launch {
            val result = movieDetailUseCase.getMovieDetail(id)
            withContext(Dispatchers.Main) {
                when (result) {
                    is Either.Left -> {
                        _movieDetail.postValue(result.value)
                    }
                    is Either.Right -> {
                        _errorDetailMovie.postValue(result.value)
                    }
                }

            }
        }
    }

    override fun setTVDetailId(id: Int) {
        _tvDetailId.postValue(id)
    }

    override fun getTVDetail(id: Int) {
        viewModelScope.launch {
            val result = movieDetailUseCase.getTVDetail(id)
            withContext(Dispatchers.Main) {
                when (result) {
                    is Either.Left -> {
                        _tvDetail.postValue(result.value)
                    }
                    is Either.Right -> {
                        _errorDetailTV.postValue(result.value)
                    }
                }

            }
        }
    }

}