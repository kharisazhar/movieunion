package com.dicoding.movieunion

import com.dicoding.movieunion.feature.movie.presentation.viewmodel.MovieViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = movieViewModel.getMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.movieResults.size)
    }

    @Test
    fun getTVShow() {
        val tvShowEntites = movieViewModel.getTVShow()
        assertNotNull(tvShowEntites)
        assertEquals(10, tvShowEntites.tvShowResult.size)
    }
}