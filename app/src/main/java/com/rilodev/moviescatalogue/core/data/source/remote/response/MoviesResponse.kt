package com.rilodev.moviescatalogue.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class MoviesResponse(
    @field:SerializedName("page")
    val page: Int,
    @field:SerializedName("results")
    val result: ArrayList<MovieResponse>,
): Parcelable