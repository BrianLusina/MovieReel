package com.moviereel.domain.models

/**
 * @author lusinabrian on 09/08/17.
 * @Notes Base entity for objects
 */
open class BaseEntity(
        open var voteCount: Int = 0,
        open var id: Long = 0,
        open var video: Boolean = false,
        open var voteAverage: Float = 0F,
        open var title: String = "",
        open var popularity: Float = 0F,
        open var posterPath: String? = "",
        open var originalLanguage: String? = "",
        open var originalTitle: String = "",
        open var genreIds: List<Int> = listOf(),
        open var backdropPath: String? = null,
        open var isAdult: Boolean = false,
        open var overview: String? = "",
        open var releaseDate: String = ""
)