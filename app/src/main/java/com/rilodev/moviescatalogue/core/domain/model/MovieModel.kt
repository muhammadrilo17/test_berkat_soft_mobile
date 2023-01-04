package com.rilodev.moviescatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(
    val id: String,
    val name: String,
    val imagePath: String,
    val releaseDate: String,
):Parcelable