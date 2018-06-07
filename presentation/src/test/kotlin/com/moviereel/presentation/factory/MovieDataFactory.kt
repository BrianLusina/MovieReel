package com.moviereel.presentation.factory

import com.moviereel.domain.models.movies.MovieNowPlayingDomainModel

class MovieDataFactory {
    
    companion object NowPlayingFactory {

        fun makeMoviesNowPlayingList(count: Int): List<MovieNowPlayingDomainModel> {
            val moviesNowPlaying = mutableListOf<MovieNowPlayingDomainModel>()
            repeat(count) {
                moviesNowPlaying.add(makeMovieNowPlaying())
            }
            return moviesNowPlaying
        }

        fun makeMovieNowPlaying(): MovieNowPlayingDomainModel {
            return MovieNowPlayingDomainModel(
                    randomId(), randomVoteCount(), randomBoolean(),
                    randomVoteAverage(), randomTitle(), randomPopularity(),
                    randomPosterPath(), randomOriginalLang(), randomTitle(),
                    randomGenreIds(), randomBackdropPath(), randomBoolean(),
                    randomOverview(1000), randomReleaseDate()
            )
        }
    }
}
