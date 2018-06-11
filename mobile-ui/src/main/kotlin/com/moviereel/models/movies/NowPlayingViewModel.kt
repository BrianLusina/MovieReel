package com.moviereel.models.movies

/**
 * @author lusinabrian on 07/06/18.
 * @Notes Representation of a Now Playing Movie model in the view layer
 */
data class NowPlayingViewModel(
        var voteCount: Int,
        var id: Long,
        var video: Boolean,
        var voteAverage: Float,
        var title: String,
        var popularity: Float,
        var posterPath: String,
        var originalLanguage: String,
        var originalTitle: String,
        var genreIds: List<Int>,
        var backdropPath: String,
        var isAdult: Boolean,
        var overview: String,
        var releaseDate: String
)