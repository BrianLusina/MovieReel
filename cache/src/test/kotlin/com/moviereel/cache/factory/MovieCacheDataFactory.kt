package com.moviereel.cache.factory

import com.moviereel.cache.db.models.movie.MovieNowPlayingCacheModel
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity

/**
 * @author lusinabrian on 27/04/18.
 * @Notes Factory class for related instances
 * */

class MovieCacheDataFactory {
    
    companion object MovieNowPlayingFactory{

        fun makeMoviesNowPlayingCacheList(count: Int): List<MovieNowPlayingCacheModel> {
            val moviesNowPlaying = mutableListOf<MovieNowPlayingCacheModel>()
            repeat(count) {
                moviesNowPlaying.add(makeMovieNowPlayingCacheModel())
            }
            return moviesNowPlaying
        }

        fun makeMoviesNowPlayingModelList(count: Int): List<MovieNowPlayingDataEntity> {
            val moviesNowPlaying = mutableListOf<MovieNowPlayingDataEntity>()
            repeat(count) {
                moviesNowPlaying.add(makeMovieNowPlayingDataEntity())
            }
            return moviesNowPlaying
        }

        fun makeMovieNowPlayingCacheModel(): MovieNowPlayingCacheModel {
            return MovieNowPlayingCacheModel(
                    randomVoteCount(), randomId(), randomBoolean(),
                    randomVoteAverage(), randomTitle(), randomPopularity(),
                    randomPosterPath(), randomOriginalLang(), randomTitle(),
                    randomGenreIds(), randomBackdropPath(), randomBoolean(),
                    randomOverview(1000), randomReleaseDate()
            )
        }

        fun makeMovieNowPlayingDataEntity(): MovieNowPlayingDataEntity {
            return MovieNowPlayingDataEntity(
                    randomId(), randomVoteCount(), randomBoolean(),
                    randomVoteAverage(), randomTitle(), randomPopularity(),
                    randomPosterPath(), randomOriginalLang(), randomTitle(),
                    randomGenreIds(), randomBackdropPath(), randomBoolean(),
                    randomOverview(1000), randomReleaseDate()
            )
        }
    }
}
