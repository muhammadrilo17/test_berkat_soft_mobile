package com.rilodev.moviescatalogue.pages.main.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rilodev.moviescatalogue.core.data.Resource
import com.rilodev.moviescatalogue.core.domain.model.MovieModel
import com.rilodev.moviescatalogue.core.domain.repository.IAppRepository

class PopularViewModel(private val repository: IAppRepository): ViewModel() {
    fun getPopular(): LiveData<Resource<ArrayList<MovieModel>>> {
        return repository.getPopular().asLiveData()
    }
}