package com.rilodev.moviescatalogue.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BasicResponse(
    @field:SerializedName("success")
    val error: Boolean,
    @field:SerializedName("status_message")
    val message: String
): Parcelable