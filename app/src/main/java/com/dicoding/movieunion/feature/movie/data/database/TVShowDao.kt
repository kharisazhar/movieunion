package com.dicoding.movieunion.feature.movie.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import kotlinx.coroutines.flow.Flow

@Dao
interface TVShowDao {
    @Query("SELECT * FROM tv_show_entities where isFavorite = 1")
    fun getFavoriteTVShows(): PagingSource<Int, TVShowResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteTVShow(tvShow: TVShowResult)

    @Query("DELETE FROM tv_show_entities WHERE id = :id ")
    fun deleteFavoriteTVShow(id: Int)
}