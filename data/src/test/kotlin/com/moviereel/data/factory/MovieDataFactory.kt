package com.moviereel.data.factory

import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.domain.models.movies.MovieNowPlayingModel

/**
 * @author lusinabrian on 27/04/18.
 * @Notes Factory class for [MovieNowPlayingModel] related instances
 * */

object MovieDataFactory {

    fun makeMoviesNowPlayingEntityList(count: Int): List<MovieNowPlayingDataEntity> {
        val moviesNowPlaying = mutableListOf<MovieNowPlayingDataEntity>()
        repeat(count) {
            moviesNowPlaying.add(makeMovieNowPlayingEntity())
        }
        return moviesNowPlaying
    }

    fun makeMoviesNowPlayingModelList(count: Int): List<MovieNowPlayingModel> {
        val moviesNowPlaying = mutableListOf<MovieNowPlayingModel>()
        repeat(count) {
            moviesNowPlaying.add(makeMovieNowPlayingModel())
        }
        return moviesNowPlaying
    }

    fun makeMovieNowPlayingEntity(): MovieNowPlayingDataEntity {
        return MovieNowPlayingDataEntity(
                DataFactory.randomId(), DataFactory.randomVoteCount(), DataFactory.randomBoolean(),
                DataFactory.randomVoteAverage(), DataFactory.randomTitle(), DataFactory.randomPopularity(),
                DataFactory.randomPosterPath(), DataFactory.randomOriginalLang(), DataFactory.randomTitle(),
                DataFactory.randomGenreIds(), DataFactory.randomBackdropPath(), DataFactory.randomBoolean(),
                DataFactory.randomOverview(1000), DataFactory.randomReleaseDate()
        )
    }

    fun makeMovieNowPlayingModel(): MovieNowPlayingModel {
        return MovieNowPlayingModel(
                DataFactory.randomId(), DataFactory.randomVoteCount(), DataFactory.randomBoolean(),
                DataFactory.randomVoteAverage(), DataFactory.randomTitle(), DataFactory.randomPopularity(),
                DataFactory.randomPosterPath(), DataFactory.randomOriginalLang(), DataFactory.randomTitle(),
                DataFactory.randomGenreIds(), DataFactory.randomBackdropPath(), DataFactory.randomBoolean(),
                DataFactory.randomOverview(1000), DataFactory.randomReleaseDate()
        )
    }

}
