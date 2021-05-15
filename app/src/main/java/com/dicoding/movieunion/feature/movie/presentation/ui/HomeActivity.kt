package com.dicoding.movieunion.feature.movie.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movieunion.core.utils.ExtraIntent
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_DETAIL_MOVIE
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_LIST_TYPE
import com.dicoding.movieunion.core.utils.ExtraIntent.MOVIE
import com.dicoding.movieunion.core.utils.ExtraIntent.TV_SHOW
import com.dicoding.movieunion.core.utils.OnItemClickListener
import com.dicoding.movieunion.databinding.ActivityHomeBinding
import com.dicoding.movieunion.feature.detail.presentation.DetailMovieActivity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.presentation.adapter.MovieAdapter
import com.dicoding.movieunion.feature.movie.presentation.adapter.TVShowAdapter
import com.dicoding.movieunion.feature.movie.presentation.viewmodel.MovieViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var tvShowAdapter: TVShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MovieViewModel::class.java]
        val courses = viewModel.getMovie()
        val tvShows = viewModel.getTVShow()

        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        initMovieRecyclerView(courses.movieResults)
        initTVShowRecyclerView(tvShows.tvShowResult)

        activityHomeBinding.tvShowMoreMovie.setOnClickListener {
            val intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra(EXTRA_LIST_TYPE, MOVIE)
            startActivity(intent)
        }

        activityHomeBinding.tvShowMoreTVSHow.setOnClickListener {
            val intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra(EXTRA_LIST_TYPE, TV_SHOW)
            startActivity(intent)
        }
    }


    private fun initMovieRecyclerView(movies: List<MovieResult>) {
        movieAdapter = MovieAdapter()
        with(activityHomeBinding.rvMovie) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
        movieAdapter.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(item: Any, position: Int) {
                val intent = Intent(this@HomeActivity, DetailMovieActivity::class.java)
                intent.putExtra(EXTRA_DETAIL_MOVIE, movies[position])
                startActivity(intent)
            }
        }
        movieAdapter.setMovies(movies)
    }

    private fun initTVShowRecyclerView(tvShows: List<TVShowResult>) {
        tvShowAdapter = TVShowAdapter()
        with(activityHomeBinding.rvTVShow) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
        tvShowAdapter.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(item: Any, position: Int) {
                val intent = Intent(this@HomeActivity, DetailMovieActivity::class.java)
                intent.putExtra(ExtraIntent.EXTRA_DETAIL_TV, tvShows[position])
                startActivity(intent)
            }
        }
        tvShowAdapter.setTVShow(tvShows)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}