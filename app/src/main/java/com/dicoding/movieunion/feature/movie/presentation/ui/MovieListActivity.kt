package com.dicoding.movieunion.feature.movie.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_ID
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_LIST_TYPE
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_TYPE
import com.dicoding.movieunion.core.utils.ExtraIntent.FAVORITE_MOVIE
import com.dicoding.movieunion.core.utils.ExtraIntent.FAVORITE_TV_SHOW
import com.dicoding.movieunion.core.utils.ExtraIntent.MOVIE
import com.dicoding.movieunion.core.utils.ExtraIntent.TV_SHOW
import com.dicoding.movieunion.core.utils.OnItemClickListener
import com.dicoding.movieunion.databinding.ActivityMovieListBinding
import com.dicoding.movieunion.feature.detail_movie.presentation.DetailMovieActivity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.presentation.adapter.movie.MovieListAdapter
import com.dicoding.movieunion.feature.movie.presentation.adapter.tv_show.TVShowListAdapter
import com.dicoding.movieunion.feature.movie.presentation.viewmodel.MovieViewModel
import com.dicoding.movieunion.feature.movie.presentation.viewmodel.TVShowViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MovieListActivity : AppCompatActivity() {

    private lateinit var activityMovieListBinding: ActivityMovieListBinding
    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var tvShowListAdapter: TVShowListAdapter

    private val movieViewModel: MovieViewModel by viewModel()
    private val tvShowViewModel: TVShowViewModel by viewModel()

    private var listType: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listType = intent.getStringExtra(EXTRA_LIST_TYPE)

        activityMovieListBinding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(activityMovieListBinding.root)

        initObserver()
    }

    private fun initObserver() {
        when (listType) {
            MOVIE -> {
                movieViewModel.movie.observe(this, { result ->
                    result?.let {
                        setRecyclerViewMovie(it)
                    }
                })
                movieViewModel.error.observe(this, {
                    Toast.makeText(this, it?.statusMessage, Toast.LENGTH_LONG).show()
                })
            }
            TV_SHOW -> {
                tvShowViewModel.tvPopular.observe(this, { result ->
                    result?.let {
                        setRecyclerViewTVSHow(it)
                    }

                })
                tvShowViewModel.error.observe(this, {
                    Toast.makeText(this, it?.statusMessage, Toast.LENGTH_LONG).show()
                })
            }
            FAVORITE_MOVIE -> {
                movieViewModel.movieFavorite.observe(this, { result ->
                    result?.let {
                        setRecyclerViewMovie(result)
                    }
                })
            }
            FAVORITE_TV_SHOW -> {
                tvShowViewModel.tvShowsFavorite.observe(this, { result ->
                    result?.let {
                        setRecyclerViewTVSHow(result)
                    }
                })
            }
        }
    }

    private fun setRecyclerViewMovie(movieResults: List<MovieResult>) {
        movieListAdapter = MovieListAdapter()
        with(activityMovieListBinding.rvMovieSeeMore) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = movieListAdapter
        }
        movieListAdapter.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(item: Any, position: Int) {
                val intent = Intent(this@MovieListActivity, DetailMovieActivity::class.java)
                intent.putExtra(EXTRA_TYPE, MOVIE)
                intent.putExtra(EXTRA_ID, movieResults[position].id)
                startActivity(intent)
            }
        }
        movieListAdapter.setMovies(movieResults)
    }

    private fun setRecyclerViewTVSHow(tvShowResults: List<TVShowResult>) {
        tvShowListAdapter = TVShowListAdapter()
        with(activityMovieListBinding.rvMovieSeeMore) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = tvShowListAdapter
        }
        tvShowListAdapter.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(item: Any, position: Int) {
                val intent = Intent(this@MovieListActivity, DetailMovieActivity::class.java)
                intent.putExtra(EXTRA_TYPE, TV_SHOW)
                intent.putExtra(EXTRA_ID, tvShowResults[position].id)
                startActivity(intent)
            }
        }
        tvShowListAdapter.setTVShow(tvShowResults)
    }
}