package com.rilodev.moviescatalogue.core.domain.repository

import com.rilodev.moviescatalogue.core.data.Resource
import com.rilodev.moviescatalogue.core.domain.model.MovieModel
import kotlinx.coroutines.flow.Flow

interface IAppRepository {
    fun getNowPlaying(): Flow<Resource<ArrayList<MovieModel>>>
    fun getPopular(): Flow<Resource<ArrayList<MovieModel>>>
    fun getTopRated(): Flow<Resource<ArrayList<MovieModel>>>
    fun getUpcoming(): Flow<Resource<ArrayList<MovieModel>>>
}