package com.dicoding.movieunion.feature.movie.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity

class MovieViewModel : ViewModel() {
    fun getMovie(): MovieEntity = DataDummy.generateDummyMovie()
    fun getTVShow(): TVShowEntity = DataDummy.generateDummyTVSHow()
}