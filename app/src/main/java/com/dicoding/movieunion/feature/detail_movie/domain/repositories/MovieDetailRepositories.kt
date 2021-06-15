package com.dicoding.movieunion.feature.detail_movie.domain.repositories

import com.dicoding.movieunion.feature.detail_movie.domain.entities.MovieDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.entities.TVDetailEntity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import retrofit2.Response

interface MovieDetailRepositories {
    suspend fun getMovieDetail(id: Int): Response<MovieDetailEntity>
    suspend fun getTVDetail(id: Int): Response<TVDetailEntity>
    suspend fun insertFavoriteMovie(movie: MovieResult)
    suspend fun deleteFavoriteMovie(id: Int)
    suspend fun insertFavoriteTVShow(tvShow: TVShowResult)
    suspend fun deleteFavoriteTVShow(id: Int)
}