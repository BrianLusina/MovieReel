package com.moviereel.cache.db.entities

/**
 * @author lusinabrian on 09/08/17.
 * @Notes Base entity for objects
 */
interface BaseEntity {
        var voteCount: Int
        var id: Long
        var video: Boolean
        var voteAverage: Float
        var title: String
        var popularity: Float
        var posterPath: String?
        var originalLanguage: String?
        var originalTitle: String
        var genreIds: List<Int>
        var backdropPath: String
        var isAdult: Boolean
        var overview: String?
        var releaseDate: String
}