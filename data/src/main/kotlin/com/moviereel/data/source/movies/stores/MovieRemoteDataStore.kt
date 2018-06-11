package com.moviereel.data.source.movies.stores

import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.data.source.movies.repo.MovieRemoteRepo
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Implementation of the [MovieDataStore] interface to provide a means of communicating
 * with the remote data source
*/
open class MovieRemoteDataStore @Inject constructor(private val movieRemoteRepo: MovieRemoteRepo): MovieDataStore {
    override fun saveMovieNowPlaying(movieNowPlaying: MovieNowPlayingDataEntity): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearMoviesNowPlaying(): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearAllMovies(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveMoviesNowPlaying(moviesNowPlaying: List<MovieNowPlayingDataEntity>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of Movies Now Playing from API
     */
    override fun getMoviesNowPlaying(page: Int, language: String): Single<List<MovieNowPlayingDataEntity>> {
        return movieRemoteRepo.getMoviesNowPlaying(page, language)
    }

    // we can't retrieve a single movie that is now playing from remote
    override fun getMovieNowPlaying(id: Long): Single<MovieNowPlayingDataEntity> {
        throw UnsupportedOperationException()
    }
}