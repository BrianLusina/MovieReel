package com.moviereel.data.models.movies

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Representation for a [MovieNowPlayingEntity] fetched from an external layer data source
 */
data class MovieNowPlayingEntity(var id: Long, var voteCount: Int, var video: Boolean, var voteAverage: Float,
                                 var title: String, var popularity: Float, var posterPath: String,
                                 var originalLang: String, var originalTitle: String,
                                 var genreIds: List<Int>, var backdropPath: String, var adult: Boolean,
                                 var overview: String, var releaseDate: String)