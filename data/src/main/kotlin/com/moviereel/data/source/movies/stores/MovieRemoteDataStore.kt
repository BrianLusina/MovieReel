package com.moviereel.data.source.movies.stores

import com.moviereel.data.models.movies.MovieNowPlayingEntity
import com.moviereel.data.source.movies.repo.MovieRemote
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Implementation of the [MovieDataStore] interface to provide a means of communicating
 * with the remote data source
*/
class MovieRemoteDataStore @Inject constructor(private val movieRemote: MovieRemote): MovieDataStore {

    override fun clearAllMovies(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveMoviesNowPlaying(moviesNowPlaying: List<MovieNowPlayingEntity>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of Movies Now Playing from API
     */
    override fun getMoviesNowPlaying(): Single<List<MovieNowPlayingEntity>> {
        return movieRemote.getMoviesNowPlaying()
    }
}