package com.rilodev.moviescatalogue.core.utils.mapper

import com.rilodev.moviescatalogue.core.data.source.remote.response.MovieResponse
import com.rilodev.moviescatalogue.core.domain.model.MovieModel

object MovieMapper {
    fun mapResponseToDomain(input: MovieResponse): MovieModel {
        return MovieModel(
            id = input.id,
            name = input.movieName,
            imagePath = input.imagePath,
            releaseDate = input.releaseDate,
        )
    }
}