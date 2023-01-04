package com.rilodev.moviescatalogue.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("original_title")
    val movieName: String,
    @field:SerializedName("poster_path")
    val imagePath: String,
    @field:SerializedName("release_date")
    val releaseDate: String,
): Parcelable