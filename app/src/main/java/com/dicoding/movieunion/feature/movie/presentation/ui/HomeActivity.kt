package com.dicoding.movieunion.feature.movie.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_ID
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_LIST_TYPE
import com.dicoding.movieunion.core.utils.ExtraIntent.EXTRA_TYPE
import com.dicoding.movieunion.core.utils.ExtraIntent.FAVORITE_MOVIE
import com.dicoding.movieunion.core.utils.ExtraIntent.FAVORITE_TV_SHOW
import com.dicoding.movieunion.core.utils.ExtraIntent.MOVIE
import com.dicoding.movieunion.core.utils.ExtraIntent.TV_SHOW
import com.dicoding.movieunion.core.utils.OnItemClickListener
import com.dicoding.movieunion.databinding.ActivityHomeBinding
import com.dicoding.movieunion.feature.detail_movie.presentation.DetailMovieActivity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.presentation.adapter.movie.FavoriteMovieAdapter
import com.dicoding.movieunion.feature.movie.presentation.adapter.movie.MovieAdapter
import com.dicoding.movieunion.feature.movie.presentation.adapter.tv_show.FavoriteTVShowAdapter
import com.dicoding.movieunion.feature.movie.presentation.adapter.tv_show.TVShowAdapter
import com.dicoding.movieunion.feature.movie.presentation.viewmodel.MovieViewModel
import com.dicoding.movieunion.feature.movie.presentation.viewmodel.TVShowViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var tvShowAdapter: TVShowAdapter
    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter
    private lateinit var favoriteTVShowAdapter: FavoriteTVShowAdapter

    private val movieViewModel: MovieViewModel by viewModel()
    private val tvShowViewModel: TVShowViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        initView()
        initObserver()
    }

    private fun initView() {
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

        activityHomeBinding.tvShowMoreFavoriteMovie.setOnClickListener {
            val intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra(EXTRA_LIST_TYPE, FAVORITE_MOVIE)
            startActivity(intent)
        }

        activityHomeBinding.tvShowMoreFavoriteTV.setOnClickListener {
            val intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra(EXTRA_LIST_TYPE, FAVORITE_TV_SHOW)
            startActivity(intent)
        }


    }

    private fun initObserver() {
        movieViewModel.movie.observe(this, { result ->
            result?.let {
                initMovieRecyclerView(it)
            }
        })

        movieViewModel.error.observe(this, {
            Toast.makeText(this, it?.statusMessage, Toast.LENGTH_LONG).show()
        })

        tvShowViewModel.tvPopular.observe(this, { result ->
            result?.let {
                initTVShowRecyclerView(result)
            }

        })

        tvShowViewModel.error.observe(this, {
            Toast.makeText(this, it?.statusMessage, Toast.LENGTH_LONG).show()
        })

        movieViewModel.movieFavorite.observe(this, { result ->
            result?.let {
                initFavoriteMovieRecyclerView(it)
            }
        })

        tvShowViewModel.tvShowsFavorite.observe(this, { result ->
            result?.let {
                initFavoriteTVRecyclerView(it)
            }
        })
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
                intent.putExtra(EXTRA_TYPE, MOVIE)
                intent.putExtra(EXTRA_ID, movies[position].id)
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
                intent.putExtra(EXTRA_TYPE, TV_SHOW)
                intent.putExtra(EXTRA_ID, tvShows[position].id)
                startActivity(intent)
            }
        }
        tvShowAdapter.setTVShow(tvShows)
    }

    private fun initFavoriteMovieRecyclerView(favoriteMovie: List<MovieResult>) {
        favoriteMovieAdapter = FavoriteMovieAdapter()
        with(activityHomeBinding.rvFavoriteMovie) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = favoriteMovieAdapter
        }
        favoriteMovieAdapter.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(item: Any, position: Int) {
                val intent = Intent(this@HomeActivity, DetailMovieActivity::class.java)
                intent.putExtra(EXTRA_TYPE, MOVIE)
                intent.putExtra(EXTRA_ID, favoriteMovie[position].id)
                startActivity(intent)
            }
        }
        favoriteMovieAdapter.setFavoriteMovies(favoriteMovie)
    }

    private fun initFavoriteTVRecyclerView(favoriteTVShow: List<TVShowResult>) {
        favoriteTVShowAdapter = FavoriteTVShowAdapter()
        with(activityHomeBinding.rvFavoriteTV) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = favoriteTVShowAdapter
        }
        favoriteTVShowAdapter.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(item: Any, position: Int) {
                val intent = Intent(this@HomeActivity, DetailMovieActivity::class.java)
                intent.putExtra(EXTRA_TYPE, TV_SHOW)
                intent.putExtra(EXTRA_ID, favoriteTVShow[position].id)
                startActivity(intent)
            }
        }
        favoriteTVShowAdapter.setFavoriteTVShows(favoriteTVShow)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}