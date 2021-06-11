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
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.presentation.viewmodel.MovieViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private var genre: String = ""
    private var isFavorite = false
    private var movieId: Int = -1

    private val movieDetailViewModel: MovieDetailViewModel by viewModel()
    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(activityDetailMovieBinding.root)

        val type = intent.getStringExtra(EXTRA_TYPE)
        movieId = intent.getIntExtra(EXTRA_ID, 0)

        if (type == MOVIE) {
            movieDetailViewModel.getMovieDetail(movieId)
        } else if (type == TV_SHOW) {
            movieDetailViewModel.getTVDetail(movieId)
        }

        activityDetailMovieBinding.btnBackDetail.setOnClickListener {
            finish()
        }

        initObserve()

    }

    private fun initViewFavoriteButton() {
        if (!isFavorite) {
            activityDetailMovieBinding.fabFavorite.setImageResource(R.drawable.ic_favorite_inactive)
        } else {
            activityDetailMovieBinding.fabFavorite.setImageResource(R.drawable.ic_favorite_active)
        }

    }

    private fun setFavoriteMovie(movie: MovieDetailEntity) {
        activityDetailMovieBinding.fabFavorite.setOnClickListener {
            if (!isFavorite) {
                isFavorite = true
                activityDetailMovieBinding.fabFavorite.setImageResource(R.drawable.ic_favorite_active)
                insertMovieFavorite(movie)
            } else {
                isFavorite = false
                activityDetailMovieBinding.fabFavorite.setImageResource(R.drawable.ic_favorite_inactive)
                movieDetailViewModel.deleteFavoriteMovie(movie.id)
            }
        }
    }

    private fun insertMovieFavorite(movie: MovieDetailEntity) {
        movieDetailViewModel.insertFavoriteMovie(
            MovieResult(
                id = movie.id,
                adult = movie.adult,
                backdropPath = movie.backdropPath,
                originalLanguage = movie.originalLanguage,
                originalTitle = movie.originalTitle,
                overview = movie.overview,
                popularity = movie.popularity,
                posterPath = movie.posterPath,
                releaseDate = movie.releaseDate,
                title = movie.title,
                video = movie.video,
                voteAverage = movie.voteAverage,
                voteCount = movie.voteCount,
                isFavorite = true
            )
        )
    }

    private fun initObserve() {
        movieDetailViewModel.movieDetail.observe(this, {
            it?.let {
                setDetailMovie(it)
                setFavoriteMovie(it)
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

        movieViewModel.movieFavorite.observe(this, { movies ->
            val data = movies?.filter {
                it.id == movieId
            }
            isFavorite = if (data!!.isNotEmpty()) {
                data[0].isFavorite!!
            } else {
                false
            }

            initViewFavoriteButton()
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