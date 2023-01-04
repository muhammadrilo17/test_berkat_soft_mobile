package com.rilodev.moviescatalogue.pages.detailmovie

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rilodev.moviescatalogue.core.domain.model.MovieModel
import com.rilodev.moviescatalogue.core.utils.Constants.BASE_IMAGE_URL
import com.rilodev.moviescatalogue.core.utils.Constants.EXTRA_INTENT_DATA
import com.rilodev.moviescatalogue.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {
    private var _binding: ActivityDetailMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        initData()
    }

    private fun initData() {
        val dataIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_INTENT_DATA, MovieModel::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_INTENT_DATA)
        }
        if (dataIntent != null) {
            Glide.with(this).load(BASE_IMAGE_URL+dataIntent.imagePath).into(binding.image)
            binding.movieName.text = dataIntent.name
            binding.releaseDate.text = dataIntent.releaseDate
        }
    }
}