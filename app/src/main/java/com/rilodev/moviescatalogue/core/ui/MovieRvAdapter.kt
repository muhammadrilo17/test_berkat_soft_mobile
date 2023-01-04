package com.rilodev.moviescatalogue.core.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rilodev.moviescatalogue.R
import com.rilodev.moviescatalogue.core.domain.model.MovieModel
import com.rilodev.moviescatalogue.core.utils.Constants.BASE_IMAGE_URL
import com.rilodev.moviescatalogue.databinding.ItemNowPlayingBinding

class MovieRvAdapter(private val context: Context) :
    RecyclerView.Adapter<MovieRvAdapter.ViewHolder>() {
    private var dataMovies = ArrayList<MovieModel>()

    var onItemClick: ((MovieModel, ItemNowPlayingBinding) -> Unit)? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemNowPlayingBinding.bind(view)

        fun bind(data: MovieModel) {
            with(binding) {
                movieName.text = data.name

                Glide.with(context).load(BASE_IMAGE_URL+data.imagePath).into(image)
                releaseDate.text = data.releaseDate
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(dataMovies[adapterPosition], binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_now_playing, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataMovies[position])
    }

    override fun getItemCount(): Int = dataMovies.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(movies: ArrayList<MovieModel>) {
        dataMovies.clear()
        dataMovies.addAll(movies)
        notifyDataSetChanged()
    }
}