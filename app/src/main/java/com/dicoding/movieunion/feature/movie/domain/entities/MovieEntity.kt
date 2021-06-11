package com.dicoding.movieunion.feature.movie.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movieResults: List<MovieResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) : Parcelable

@Entity(tableName = "movie_entities")
@Parcelize
data class MovieResult(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("adult")
    @ColumnInfo(name = "adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdropPath")
    val backdropPath: String,
    @SerializedName("original_language")
    @ColumnInfo(name = "originalLanguage")
    val originalLanguage: String,
    @SerializedName("original_title")
    @ColumnInfo(name = "originalTitle")
    val originalTitle: String,
    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    val overview: String,
    @SerializedName("popularity")
    @ColumnInfo(name = "popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    @ColumnInfo(name = "posterPath")
    val posterPath: String,
    @SerializedName("release_date")
    @ColumnInfo(name = "releaseDate")
    val releaseDate: String,
    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title: String,
    @SerializedName("video")
    @ColumnInfo(name = "video")
    val video: Boolean,
    @SerializedName("vote_average")
    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double,
    @SerializedName("vote_count")
    @ColumnInfo(name = "voteCount")
    val voteCount: Int,
    @SerializedName("is_favorite")
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean? = false,
) : Parcelable