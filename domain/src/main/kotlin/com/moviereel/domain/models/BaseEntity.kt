package com.moviereel.domain.models

/**
 * @author lusinabrian on 09/08/17.
 * @Notes Base entity for objects
 */
 open class BaseEntity(
        var voteCount: Int,
        var id: Long = 0,
        var video: Boolean = false,
        var voteAverage: Float = 0F,
        var title: String = "",
        var popularity: Float = 0F,
        var posterPath: String? = "",
        var originalLanguage: String? = "",
        var originalTitle: String = "",
        var genreIds: List<Int> = listOf(),
        var backdropPath: String? = null,
        var isAdult: Boolean = false,
        var overview: String? = "",
        var releaseDate: String = ""
)