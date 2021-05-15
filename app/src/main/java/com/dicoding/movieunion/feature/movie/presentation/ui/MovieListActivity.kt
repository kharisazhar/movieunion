package com.dicoding.movieunion.feature.movie.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.movieunion.core.utils.ExtraIntent
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_LIST_TYPE
import com.dicoding.movieunion.core.utils.ExtraIntent.MOVIE
import com.dicoding.movieunion.core.utils.ExtraIntent.TV_SHOW
import com.dicoding.movieunion.core.utils.OnItemClickListener
import com.dicoding.movieunion.databinding.ActivityMovieListBinding
import com.dicoding.movieunion.feature.detail.presentation.DetailMovieActivity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.presentation.adapter.MovieListAdapter
import com.dicoding.movieunion.feature.movie.presentation.adapter.TVShowListAdapter
import com.dicoding.movieunion.feature.movie.presentation.viewmodel.MovieViewModel

class MovieListActivity : AppCompatActivity() {

    private lateinit var activityMovieListBinding: ActivityMovieListBinding
    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var tvShowListAdapter: TVShowListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MovieViewModel::class.java]

        val listType = intent.getStringExtra(EXTRA_LIST_TYPE)

        activityMovieListBinding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(activityMovieListBinding.root)

        if (listType == MOVIE) {
            setRecyclerViewMovie(viewModel.getMovie().movieResults)
        } else if (listType == TV_SHOW) {
            setRecyclerViewTVSHow(viewModel.getTVShow().tvShowResult)
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
                intent.putExtra(ExtraIntent.EXTRA_DETAIL_MOVIE, movieResults[position])
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
                intent.putExtra(ExtraIntent.EXTRA_DETAIL_TV, tvShowResults[position])
                startActivity(intent)
            }
        }
        tvShowListAdapter.setTVShow(tvShowResults)
    }
}