package com.moviereel.domain.models.movies

/**
 * @author lusinabrian
 * @Notes: Now playing movie model represents a single Now playing movie fetched from an external layer data source
 */

data class MovieNowPlayingDomainModel(var id: Long, var voteCount: Int, var video: Boolean, var voteAverage: Float,
                                      var title: String, var popularity: Float, var posterPath: String,
                                      var originalLang: String, var originalTitle: String,
                                      var genreIds: List<Int>, var backdropPath: String, var adult: Boolean,
                                      var overview: String, var releaseDate: String)