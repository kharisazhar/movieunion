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
import com.dicoding.movieunion.databinding.ItemMovieBinding
import com.dicoding.movieunion.feature.detail_movie.presentation.DetailMovieActivity
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.presentation.adapter.tv_show.FavoriteTVShowAdapter.FavoriteTVViewHolder


class FavoriteTVShowAdapter : PagingDataAdapter<TVShowResult, FavoriteTVViewHolder>(DIFF_CALLBACK) {

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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteTVViewHolder {
        val itemsAcademyBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTVViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(
        holder: FavoriteTVViewHolder,
        position: Int
    ) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class FavoriteTVViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShowResult) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvReleaseDate.text = tvShow.firstAirDate

                root.setOnClickListener {
                    val intent = Intent(root.context, DetailMovieActivity::class.java)
                    intent.putExtra(ExtraIntent.EXTRA_TYPE, ExtraIntent.TV_SHOW)
                    intent.putExtra(ExtraIntent.EXTRA_ID, tvShow.id)
                    intent.putExtra(ExtraIntent.EXTRA_IS_FAVORITE, tvShow.isFavorite)
                    root.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load("${BuildConfig.BASE_URL_IMAGE}w342" + tvShow.posterPath)
                    .into(imgPoster)
            }
        }
    }
}