package com.rilodev.moviescatalogue.di

import com.rilodev.moviescatalogue.core.data.AppRepository
import com.rilodev.moviescatalogue.core.data.source.remote.RemoteDataSource
import com.rilodev.moviescatalogue.core.data.source.remote.network.ApiConfig

object Injection {
    fun provideAppRepository(): AppRepository {
        val remoteDataSource = RemoteDataSource(ApiConfig.getInstance())
        return AppRepository(remoteDataSource)
    }
}