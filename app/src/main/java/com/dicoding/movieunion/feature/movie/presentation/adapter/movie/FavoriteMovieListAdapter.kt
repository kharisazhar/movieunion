package com.dicoding.movieunion.feature.movie.presentation.adapter.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.core.utils.ExtraIntent
import com.dicoding.movieunion.databinding.ItemMovieListBinding
import com.dicoding.movieunion.feature.detail_movie.presentation.DetailMovieActivity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult

class FavoriteMovieListAdapter :
    PagingDataAdapter<MovieResult, FavoriteMovieListAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieResult>() {
            override fun areItemsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMoveListBinding =
            ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMoveListBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }


    inner class MovieViewHolder(private val binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieResult) {
            with(binding) {
                tvTitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate

                root.setOnClickListener {
                    val intent = Intent(root.context, DetailMovieActivity::class.java)
                    intent.putExtra(ExtraIntent.EXTRA_TYPE, ExtraIntent.MOVIE)
                    intent.putExtra(ExtraIntent.EXTRA_ID, movie.id)
                    intent.putExtra(ExtraIntent.EXTRA_IS_FAVORITE, movie.isFavorite)
                    root.context.startActivity(intent)
                }


                Glide.with(itemView.context)
                    .load("${BuildConfig.BASE_URL_IMAGE}w342" + movie.posterPath)
                    .into(imgPoster)
            }
        }
    }
}