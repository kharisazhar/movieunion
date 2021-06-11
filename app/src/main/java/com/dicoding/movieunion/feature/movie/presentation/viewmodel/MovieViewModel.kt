package com.dicoding.movieunion.feature.movie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.usecases.MovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface MovieViewModelContract {
    fun getMovies()
    fun getFavoriteMovie()
}

class MovieViewModel(private var movieUseCase: MovieUseCase) : ViewModel(), MovieViewModelContract {

    private val _movie = MediatorLiveData<List<MovieResult>?>()
    val movie: LiveData<List<MovieResult>?>
        get() = _movie

    private val _movieFavorite = MediatorLiveData<List<MovieResult>?>()
    val movieFavorite: LiveData<List<MovieResult>?>
        get() = _movieFavorite

    private val _error = MediatorLiveData<BaseErrorResponse?>()
    val error: LiveData<BaseErrorResponse?>
        get() = _error

    init {
        getMovies()
        getFavoriteMovie()
    }

    override fun getMovies() {
        viewModelScope.launch {
            val resultNetwork = movieUseCase.getMovies()
            withContext(Dispatchers.Main) {
                when (resultNetwork) {
                    is Either.Left -> {
                        _movie.postValue(resultNetwork.value)

                    }
                    is Either.Right -> {
                        _error.postValue(resultNetwork.value)
                    }
                }

            }
        }
    }

    override fun getFavoriteMovie() {
        viewModelScope.launch {
            val result = movieUseCase.getFavoriteMovie()
            result?.collect {
                withContext(Dispatchers.Main) {
                    _movieFavorite.postValue(it)
                }
            }
        }
    }
}