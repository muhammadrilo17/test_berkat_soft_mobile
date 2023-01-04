package com.rilodev.moviescatalogue.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rilodev.moviescatalogue.core.domain.repository.IAppRepository
import com.rilodev.moviescatalogue.di.Injection
import com.rilodev.moviescatalogue.pages.main.nowplaying.NowPlayingViewModel
import com.rilodev.moviescatalogue.pages.main.popular.PopularViewModel
import com.rilodev.moviescatalogue.pages.main.toprated.TopRatedViewModel
import com.rilodev.moviescatalogue.pages.main.upcoming.UpcomingViewModel

class ViewModelFactory private constructor(private val repository: IAppRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideAppRepository())
        }.also { instance = it }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NowPlayingViewModel::class.java) -> {
                NowPlayingViewModel(repository) as T
            }
            modelClass.isAssignableFrom(PopularViewModel::class.java) -> {
                PopularViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TopRatedViewModel::class.java) -> {
                TopRatedViewModel(repository) as T
            }
            modelClass.isAssignableFrom(UpcomingViewModel::class.java) -> {
                UpcomingViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}