package com.dicoding.movieunion.feature.movie.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_entities")
    fun getMovies(): Flow<List<MovieResult>>

    @Query("SELECT * FROM movie_entities where isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieResult>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(courses: List<MovieResult>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(movie: MovieResult)

    @Query("DELETE FROM movie_entities WHERE id = :id ")
    fun deleteFavoriteMovie(id: Int)
}