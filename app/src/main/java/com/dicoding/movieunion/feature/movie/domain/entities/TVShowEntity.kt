package com.dicoding.movieunion.feature.movie.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVShowEntity(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val tvShowResult: List<TVShowResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) : Parcelable

@Entity(tableName = "tv_show_entities")
@Parcelize
data class TVShowResult(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    @SerializedName("first_air_date")
    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String,
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String,
    @SerializedName("origin_country")
    @ColumnInfo(name = "origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @SerializedName("original_name")
    @ColumnInfo(name = "original_name")
    val originalName: String,
    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    val overview: String,
    @SerializedName("popularity")
    @ColumnInfo(name = "popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,
    @SerializedName("is_favorite")
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean? = false
) : Parcelable