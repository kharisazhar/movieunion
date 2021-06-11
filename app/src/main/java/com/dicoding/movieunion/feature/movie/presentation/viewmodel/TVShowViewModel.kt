package com.dicoding.movieunion.feature.movie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.movieunion.core.network.BaseErrorResponse
import com.dicoding.movieunion.core.utils.Either
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.domain.usecases.TVUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


interface TVShowViewModelContract {
    fun getTVPopular()
    fun getFavoriteTVShows()
}

class TVShowViewModel(private var tvUseCase: TVUseCase) : ViewModel(),
    TVShowViewModelContract {

    private val _tvPopular = MediatorLiveData<List<TVShowResult>?>()
    val tvPopular: LiveData<List<TVShowResult>?>
        get() = _tvPopular

    private val _tvShowsFavorite = MediatorLiveData<List<TVShowResult>?>()
    val tvShowsFavorite: LiveData<List<TVShowResult>?>
        get() = _tvShowsFavorite

    private val _error = MediatorLiveData<BaseErrorResponse?>()
    val error: LiveData<BaseErrorResponse?>
        get() = _error

    init {
        getTVPopular()
        getFavoriteTVShows()
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

    override fun getFavoriteTVShows() {
        viewModelScope.launch {
            val result = tvUseCase.getFavoriteTVShow()
            result?.collect {
                withContext(Dispatchers.Main) {
                    _tvShowsFavorite.postValue(it)
                }
            }
        }
    }
}