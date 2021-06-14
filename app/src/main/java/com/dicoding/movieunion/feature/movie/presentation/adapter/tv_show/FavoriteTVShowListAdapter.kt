package com.dicoding.movieunion.feature.movie.presentation.adapter.tv_show

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
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult


class FavoriteTVShowListAdapter :
    PagingDataAdapter<TVShowResult, FavoriteTVShowListAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVShowResult>() {
            override fun areItemsTheSame(oldItem: TVShowResult, newItem: TVShowResult): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TVShowResult, newItem: TVShowResult): Boolean {
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
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }


    inner class MovieViewHolder(private val binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShowResult) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvReleaseDate.text = tvShow.firstAirDate

                Glide.with(itemView.context)
                    .load("${BuildConfig.BASE_URL_IMAGE}w342" + tvShow.posterPath)
                    .into(imgPoster)

                root.setOnClickListener {
                    val intent = Intent(root.context, DetailMovieActivity::class.java)
                    intent.putExtra(ExtraIntent.EXTRA_TYPE, ExtraIntent.TV_SHOW)
                    intent.putExtra(ExtraIntent.EXTRA_ID, tvShow.id)
                    intent.putExtra(ExtraIntent.EXTRA_IS_FAVORITE, tvShow.isFavorite)
                    root.context.startActivity(intent)
                }
            }
        }
    }
}