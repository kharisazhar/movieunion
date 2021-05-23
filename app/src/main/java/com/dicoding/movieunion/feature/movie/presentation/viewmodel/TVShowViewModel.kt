package com.dicoding.movieunion.feature.movie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity
import com.dicoding.movieunion.feature.movie.domain.usecases.TVUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


interface TVShowViewModelContract {
    fun getTVPopular()
}

class TVShowViewModel(private var tvUseCase: TVUseCase) : ViewModel(),
    TVShowViewModelContract {

    private val _tvPopular = MediatorLiveData<TVShowEntity?>()
    val tvPopular: LiveData<TVShowEntity?>
        get() = _tvPopular

    private val _error = MediatorLiveData<BaseErrorResponse?>()
    val error: LiveData<BaseErrorResponse?>
        get() = _error

    init {
        getTVPopular()
    }


    override fun getTVPopular() {
        viewModelScope.launch {
            val result = tvUseCase.getTVPopular()
            withContext(Dispatchers.Main) {
                when (result) {
                    is Either.Left -> {
                        _tvPopular.postValue(result.value)
                    }
                    is Either.Right -> {
                        _error.postValue(result.value)
                    }
                }

            }
        }
    }
}