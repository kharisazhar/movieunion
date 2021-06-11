package com.dicoding.movieunion.feature.movie.presentation.adapter.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.core.utils.OnItemClickListener
import com.dicoding.movieunion.databinding.ItemMovieBinding
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult

class FavoriteMovieAdapter : RecyclerView.Adapter<FavoriteMovieAdapter.FavoriteMovieViewHolder>() {
    private var listFavoriteMovies = ArrayList<MovieResult>()
    var onItemClickListener: OnItemClickListener? = null

    fun setFavoriteMovies(favoriteMovies: List<MovieResult>?) {
        if (favoriteMovies == null) return
        this.listFavoriteMovies.clear()
        this.listFavoriteMovies.addAll(favoriteMovies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val itemsAcademyBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val course = listFavoriteMovies[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listFavoriteMovies.size


    inner class FavoriteMovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieResult) {
            with(binding) {
                tvTitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate
                itemView.setOnClickListener {
                    onItemClickListener?.onItemClick(binding, bindingAdapterPosition)
                }

                Glide.with(itemView.context)
                    .load("${BuildConfig.BASE_URL_IMAGE}w342" + movie.posterPath)
                    .into(imgPoster)
            }
        }
    }
}