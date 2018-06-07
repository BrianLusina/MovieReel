package com.moviereel.presentation.model.movies

/**
 * @author lusinabrian on 04/06/18.
 * @Notes Representation of a movie now playing model in Presentation layer
 */
data class NowPlayingPresenterModel(
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