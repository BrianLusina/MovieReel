package com.moviereel.domain.factory

import com.moviereel.domain.factory.DataFactory.Factory.randomUuid
import com.moviereel.domain.models.movies.MovieNowPlayingModel

/**
 * @author lusinabrian on 27/04/18.
 * @Notes Factory class for [MovieNowPlayingModel] related instances
 * */

class MovieDataFactory {
    companion object Factory {

        fun makeMoviesNowPlayingList(count: Int): List<MovieNowPlayingModel> {
            val moviesNowPlaying = mutableListOf<MovieNowPlayingModel>()
            repeat(count) {
                moviesNowPlaying.add(makeMovieNowPlaying())
            }
            return moviesNowPlaying
        }

        fun makeMovieNowPlaying(): MovieNowPlayingModel {
            //return MovieNowPlayingModel(randomUuid(), randomUuid(), randomUuid())
            return MovieNowPlayingModel()
        }

    }
}