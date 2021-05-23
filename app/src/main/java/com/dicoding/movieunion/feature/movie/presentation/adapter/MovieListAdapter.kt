package com.dicoding.movieunion.feature.movie.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.core.utils.OnItemClickListener
import com.dicoding.movieunion.databinding.ItemMovieListBinding
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<MovieResult>()
    var onItemClickListener: OnItemClickListener? = null

    fun setMovies(courses: List<MovieResult>?) {
        if (courses == null) return
        this.listMovies.clear()
        this.listMovies.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMoveListBinding =
            ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMoveListBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val course = listMovies[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listMovies.size


    inner class MovieViewHolder(private val binding: ItemMovieListBinding) :
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