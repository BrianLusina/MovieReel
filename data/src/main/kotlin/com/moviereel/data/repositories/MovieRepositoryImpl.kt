package com.moviereel.data.repositories

import com.moviereel.data.mapper.movies.MovieNowPlayingMapper
import com.moviereel.data.source.movies.MovieDataStoreFactory
import com.moviereel.domain.models.movies.*
import com.moviereel.domain.repositories.MoviesRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Provides an implementation of the [MoviesRepository] interface for communicating to and from
 * data sources
 */
class MovieRepositoryImpl
@Inject
constructor(
        val factory: MovieDataStoreFactory,
        val movieNowPlayingMapper: MovieNowPlayingMapper)
    : MoviesRepository {

    override fun getMoviesNowPlayingList(page: Int, language: String): Flowable<List<MovieNowPlayingModel>> {
    }

    override fun getMovieNowPlaying(id: Int): Flowable<MovieNowPlayingModel> {
    }

    override fun getMoviesLatest(language: String): Flowable<MovieLatestModel> {
    }

    override fun getMoviesPopular(page: Int, language: String): Flowable<List<MoviePopularModel>> {
    }

    override fun getMoviesTopRated(page: Int, language: String, region: String): Flowable<List<MovieTopRatedModel>> {
    }

    override fun getMoviesUpcoming(page: Int, language: String, region: String): Flowable<List<MovieUpcomingModel>> {
    }

}