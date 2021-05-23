package com.dicoding.movieunion.feature.movie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import com.dicoding.movieunion.feature.movie.domain.usecases.MovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface MovieViewModelContract {
    fun getMovies()
}

class MovieViewModel(private var movieUseCase: MovieUseCase) : ViewModel(), MovieViewModelContract {

    private val _movie = MediatorLiveData<MovieEntity?>()
    val movie: LiveData<MovieEntity?>
        get() = _movie

    private val _error = MediatorLiveData<BaseErrorResponse?>()
    val error: LiveData<BaseErrorResponse?>
        get() = _error

    init {
        getMovies()
    }

    override fun getMovies() {
        viewModelScope.launch {
            val result = movieUseCase.getMovies()
            withContext(Dispatchers.Main) {
                when (result) {
                    is Either.Left -> {
                        _movie.postValue(result.value)
                    }
                    is Either.Right -> {
                        _error.postValue(result.value)
                    }
                }

            }
        }
    }
}