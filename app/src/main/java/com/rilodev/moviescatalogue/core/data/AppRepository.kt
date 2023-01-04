package com.rilodev.moviescatalogue.core.data

import com.rilodev.moviescatalogue.core.data.source.remote.RemoteDataSource
import com.rilodev.moviescatalogue.core.data.source.remote.network.ApiResponse
import com.rilodev.moviescatalogue.core.domain.model.MovieModel
import com.rilodev.moviescatalogue.core.domain.repository.IAppRepository
import com.rilodev.moviescatalogue.core.utils.Constants.API_KEY
import com.rilodev.moviescatalogue.core.utils.mapper.MovieMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class AppRepository(private val remoteDataSource: RemoteDataSource) : IAppRepository {
    override fun getNowPlaying(): Flow<Resource<ArrayList<MovieModel>>> {
        return flow {
            try {
                when(val response = remoteDataSource.getNowPlaying(API_KEY).first()) {
                    is ApiResponse.Success -> {
                        val result = response.data.map { MovieMapper.mapResponseToDomain(it) } as ArrayList
                        emit(Resource.Success(result))
                    }
                    is ApiResponse.Empty -> {
                        emit(Resource.Error("There's no Data"))
                    }
                    is ApiResponse.Error -> {
                        emit(Resource.Error(response.errorMessage))
                    }
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }

    override fun getPopular(): Flow<Resource<ArrayList<MovieModel>>> {
        return flow {
            try {
                when(val response = remoteDataSource.getPopular(API_KEY).first()) {
                    is ApiResponse.Success -> {
                        val result = response.data.map { MovieMapper.mapResponseToDomain(it) } as ArrayList
                        emit(Resource.Success(result))
                    }
                    is ApiResponse.Empty -> {
                        emit(Resource.Error("There's no Data"))
                    }
                    is ApiResponse.Error -> {
                        emit(Resource.Error(response.errorMessage))
                    }
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }

    override fun getTopRated(): Flow<Resource<ArrayList<MovieModel>>> {
        return flow {
            try {
                when(val response = remoteDataSource.getTopRated(API_KEY).first()) {
                    is ApiResponse.Success -> {
                        val result = response.data.map { MovieMapper.mapResponseToDomain(it) } as ArrayList
                        emit(Resource.Success(result))
                    }
                    is ApiResponse.Empty -> {
                        emit(Resource.Error("There's no Data"))
                    }
                    is ApiResponse.Error -> {
                        emit(Resource.Error(response.errorMessage))
                    }
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }

    override fun getUpcoming(): Flow<Resource<ArrayList<MovieModel>>> {
        return flow {
            try {
                when(val response = remoteDataSource.getUpcoming(API_KEY).first()) {
                    is ApiResponse.Success -> {
                        val result = response.data.map { MovieMapper.mapResponseToDomain(it) } as ArrayList
                        emit(Resource.Success(result))
                    }
                    is ApiResponse.Empty -> {
                        emit(Resource.Error("There's no Data"))
                    }
                    is ApiResponse.Error -> {
                        emit(Resource.Error(response.errorMessage))
                    }
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }

}