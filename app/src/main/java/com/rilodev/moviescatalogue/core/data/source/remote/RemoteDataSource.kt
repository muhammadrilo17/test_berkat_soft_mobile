package com.rilodev.moviescatalogue.core.data.source.remote

import com.google.gson.Gson
import com.rilodev.moviescatalogue.core.data.source.remote.network.ApiResponse
import com.rilodev.moviescatalogue.core.data.source.remote.network.ApiService
import com.rilodev.moviescatalogue.core.data.source.remote.response.BasicResponse
import com.rilodev.moviescatalogue.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getNowPlaying(token: String): Flow<ApiResponse<ArrayList<MovieResponse>>> {
        return flow {
            try {
                val result = apiService.getNowPlaying(token)
                if (result.result.size > 0) {
                    emit(ApiResponse.Success(result.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: HttpException) {
                val result =
                    Gson().fromJson(e.response()?.errorBody()?.string(), BasicResponse::class.java)

                emit(ApiResponse.Error(result.message))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPopular(token: String): Flow<ApiResponse<ArrayList<MovieResponse>>> {
        return flow {
            try {
                val result = apiService.getPopular(token)
                if (result.result.size > 0) {
                    emit(ApiResponse.Success(result.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: HttpException) {
                val result =
                    Gson().fromJson(e.response()?.errorBody()?.string(), BasicResponse::class.java)

                emit(ApiResponse.Error(result.message))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getTopRated(token: String): Flow<ApiResponse<ArrayList<MovieResponse>>> {
        return flow {
            try {
                val result = apiService.getTopRated(token)
                if (result.result.size > 0) {
                    emit(ApiResponse.Success(result.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: HttpException) {
                val result =
                    Gson().fromJson(e.response()?.errorBody()?.string(), BasicResponse::class.java)

                emit(ApiResponse.Error(result.message))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getUpcoming(token: String): Flow<ApiResponse<ArrayList<MovieResponse>>> {
        return flow {
            try {
                val result = apiService.getUpcoming(token)
                if (result.result.size > 0) {
                    emit(ApiResponse.Success(result.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: HttpException) {
                val result =
                    Gson().fromJson(e.response()?.errorBody()?.string(), BasicResponse::class.java)

                emit(ApiResponse.Error(result.message))
            }
        }.flowOn(Dispatchers.IO)
    }
}