package com.dicoding.movieunion.feature.movie.presentation.adapter.tv_show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.core.utils.OnItemClickListener
import com.dicoding.movieunion.databinding.ItemMovieBinding
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult
import com.dicoding.movieunion.feature.movie.presentation.adapter.tv_show.FavoriteTVShowAdapter.FavoriteTVViewHolder


class FavoriteTVShowAdapter : RecyclerView.Adapter<FavoriteTVViewHolder>() {
    private var listFavoriteTVShows = ArrayList<TVShowResult>()
    var onItemClickListener: OnItemClickListener? = null

    fun setFavoriteTVShows(favoriteMovies: List<TVShowResult>?) {
        if (favoriteMovies == null) return
        this.listFavoriteTVShows.clear()
        this.listFavoriteTVShows.addAll(favoriteMovies)
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
        val course = listFavoriteTVShows[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listFavoriteTVShows.size


    inner class FavoriteTVViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShowResult) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvReleaseDate.text = tvShow.firstAirDate
                itemView.setOnClickListener {
                    onItemClickListener?.onItemClick(binding, bindingAdapterPosition)
                }

                Glide.with(itemView.context)
                    .load("${BuildConfig.BASE_URL_IMAGE}w342" + tvShow.posterPath)
                    .into(imgPoster)
            }
        }
    }
}