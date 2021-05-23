package com.dicoding.movieunion.feature.detail_movie.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.R
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_ID
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_TYPE
import com.dicoding.movieunion.core.utils.ExtraIntent.MOVIE
import com.dicoding.movieunion.core.utils.ExtraIntent.TV_SHOW
import com.dicoding.movieunion.databinding.ActivityDetailMovieBinding
import com.dicoding.movieunion.feature.detail_movie.domain.entities.MovieDetailEntity
import com.dicoding.movieunion.feature.detail_movie.domain.entities.TVDetailEntity
import com.dicoding.movieunion.feature.detail_movie.presentation.viewmodel.MovieDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private var genre: String = ""

    private val movieDetailViewModel: MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(activityDetailMovieBinding.root)

        val type = intent.getStringExtra(EXTRA_TYPE)
        val id = intent.getIntExtra(EXTRA_ID, 0)

        if (type == MOVIE) {
            movieDetailViewModel.getMovieDetail(id)
        } else if (type == TV_SHOW) {
            movieDetailViewModel.getTVDetail(id)
        }

        initObserve()

    }

    private fun initObserve() {
        movieDetailViewModel.movieDetail.observe(this, {
            it?.let {
                setDetailMovie(it)
            }
        })

        movieDetailViewModel.tvDetail.observe(this, {
            it?.let {
                setDetailTVShow(it)
            }
        })

        movieDetailViewModel.errorDetailMovie.observe(this, {
            Toast.makeText(this, it?.statusMessage, Toast.LENGTH_LONG).show()
        })

        movieDetailViewModel.errorDetailTV.observe(this, {
            Toast.makeText(this, it?.statusMessage, Toast.LENGTH_LONG).show()
        })
    }

    private fun setDetailMovie(movieDetailEntity: MovieDetailEntity) {
        Glide.with(this)
            .load("${BuildConfig.BASE_URL_IMAGE}w1280" + movieDetailEntity.backdropPath)
            .into(activityDetailMovieBinding.imgBackdropPath)

        with(activityDetailMovieBinding) {
            tvTitle.text = movieDetailEntity.title
            tvOverview.text = movieDetailEntity.overview
            tvRating.text = "${movieDetailEntity.voteAverage / 2.0}"
            ratingBar.rating = movieDetailEntity.voteAverage.toFloat() / 2.0F

            /// GENRE
            for (i in 1..movieDetailEntity.genres.size) {
                genre += if (i == movieDetailEntity.genres.size) {
                    movieDetailEntity.genres[i - 1].name
                } else {
                    movieDetailEntity.genres[i - 1].name + ", "
                }
            }

            tvGenre.text = genre
        }
    }


    private fun setDetailTVShow(tvDetailEntity: TVDetailEntity) {
        Glide.with(this)
            .load("${BuildConfig.BASE_URL_IMAGE}w1280" + tvDetailEntity.backdropPath)
            .into(activityDetailMovieBinding.imgBackdropPath)

        with(activityDetailMovieBinding) {
            tvTitle.text = tvDetailEntity.name
            tvOverview.text = tvDetailEntity.overview
            tvRating.text = "${tvDetailEntity.voteAverage / 2.0}"
            ratingBar.rating = tvDetailEntity.voteAverage.toFloat() / 2.0F

            /// GENRE
            for (i in 1..tvDetailEntity.genres.size) {
                genre += if (i == tvDetailEntity.genres.size) {
                    tvDetailEntity.genres[i - 1].name
                } else {
                    tvDetailEntity.genres[i - 1].name + ", "
                }
            }

            tvGenre.text = genre
        }
    }
}