package com.rilodev.moviescatalogue.pages.main.nowplaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rilodev.moviescatalogue.core.data.Resource
import com.rilodev.moviescatalogue.core.domain.model.MovieModel
import com.rilodev.moviescatalogue.core.domain.repository.IAppRepository

class NowPlayingViewModel(private val repository: IAppRepository): ViewModel() {
    fun getNowPlaying(): LiveData<Resource<ArrayList<MovieModel>>> {
        return repository.getNowPlaying().asLiveData()
    }
}