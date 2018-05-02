package com.moviereel.domain.factory

import com.moviereel.domain.models.movies.MovieNowPlayingModel

/**
 * @author lusinabrian on 27/04/18.
 * @Notes Factory class for [MovieNowPlayingModel] related instances
 * */

object MovieDataFactory {

    fun makeMoviesNowPlayingList(count: Int): List<MovieNowPlayingModel> {
        val moviesNowPlaying = mutableListOf<MovieNowPlayingModel>()
        repeat(count) {
            moviesNowPlaying.add(makeMovieNowPlaying())
        }
        return moviesNowPlaying
    }

    fun makeMovieNowPlaying(): MovieNowPlayingModel {
        return MovieNowPlayingModel(
                DataFactory.randomId(), DataFactory.randomVoteCount(), DataFactory.randomBoolean(),
                DataFactory.randomVoteAverage(), DataFactory.randomTitle(), DataFactory.randomPopularity(),
                DataFactory.randomPosterPath(), DataFactory.randomOriginalLang(), DataFactory.randomTitle(),
                DataFactory.randomGenreIds(), DataFactory.randomBackdropPath(), DataFactory.randomBoolean(),
                DataFactory.randomOverview(1000), DataFactory.randomReleaseDate()
        )
    }

}
