package com.dicoding.movieunion.feature.movie.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.movieunion.BuildConfig
import com.dicoding.movieunion.core.utils.OnItemClickListener
import com.dicoding.movieunion.databinding.ItemMovieBinding
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.MovieViewHolder>() {
    private var listTVShows = ArrayList<TVShowResult>()
    var onItemClickListener: OnItemClickListener? = null

    fun setTVShow(courses: List<TVShowResult>?) {
        if (courses == null) return
        this.listTVShows.clear()
        this.listTVShows.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsAcademyBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val course = listTVShows[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listTVShows.size


    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
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