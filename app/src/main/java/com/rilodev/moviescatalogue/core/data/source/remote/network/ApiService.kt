package com.rilodev.moviescatalogue.core.data.source.remote.network

import com.rilodev.moviescatalogue.core.data.source.remote.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String
    ): MoviesResponse

    @GET("popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String
    ): MoviesResponse

    @GET("top_rated")
    suspend fun getTopRated(
        @Query("api_key") apiKey: String
    ): MoviesResponse

    @GET("upcoming")
    suspend fun getUpcoming(
        @Query("api_key") apiKey: String
    ): MoviesResponse
}