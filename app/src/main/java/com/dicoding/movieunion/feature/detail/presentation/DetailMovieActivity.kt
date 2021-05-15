package com.dicoding.movieunion.feature.detail.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.movieunion.R
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_DETAIL_MOVIE
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_DETAIL_TV
import com.dicoding.movieunion.core.utils.TranslateGenre
import com.dicoding.movieunion.databinding.ActivityDetailMovieBinding
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private var genre: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(activityDetailMovieBinding.root)

        val movieResult = intent.getParcelableExtra<MovieResult>(EXTRA_DETAIL_MOVIE)
        val tvShowResult = intent.getParcelableExtra<TVShowResult>(EXTRA_DETAIL_TV)
        if (movieResult != null) {
            setDetailMovie(movieResult)
        }

        if (tvShowResult != null) {
            setDetailTVShow(tvShowResult)
        }
    }

    private fun setDetailMovie(movieResult: MovieResult) {
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w1280" + movieResult.backdropPath)
            .into(activityDetailMovieBinding.imgBackdropPath)

        with(activityDetailMovieBinding) {
            tvTitle.text = movieResult.title
            tvOverview.text = movieResult.overview
            tvRating.text = "${movieResult.voteAverage / 2.0}"
            ratingBar.rating = movieResult.voteAverage.toFloat() / 2.0F

            /// GENRE
            for (i in 1..movieResult.genreIds.size) {
                genre += if (i == movieResult.genreIds.size) {
                    TranslateGenre().translate(movieResult.genreIds[i - 1])
                } else {
                    TranslateGenre().translate(movieResult.genreIds[i - 1]) + ", "
                }
            }

            tvGenre.text = genre
        }
    }


    private fun setDetailTVShow(tvShowResult: TVShowResult) {
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w1280" + tvShowResult.backdropPath)
            .into(activityDetailMovieBinding.imgBackdropPath)

        with(activityDetailMovieBinding) {
            tvTitle.text = tvShowResult.name
            tvOverview.text = tvShowResult.overview
            tvRating.text = "${tvShowResult.voteAverage / 2.0}"
            ratingBar.rating = tvShowResult.voteAverage.toFloat() / 2.0F

            /// GENRE
            for (i in 1..tvShowResult.genreIds.size) {
                genre += if (i == tvShowResult.genreIds.size) {
                    TranslateGenre().translate(tvShowResult.genreIds[i - 1])
                } else {
                    TranslateGenre().translate(tvShowResult.genreIds[i - 1]) + ", "
                }
            }

            tvGenre.text = genre
        }
    }
}