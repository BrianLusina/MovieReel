package com.moviereel.data.source.movies.stores

import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.data.source.movies.repo.MovieLocalRepo
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Implementation of the [MovieDataStore] interface to provide a means of communicating
 * with the local data source
 */
open class MovieCacheDataStore @Inject constructor(private val movieLocalRepo: MovieLocalRepo) : MovieDataStore {

    override fun saveMovieNowPlaying(movieNowPlaying: MovieNowPlayingDataEntity): Completable {
        return movieLocalRepo.saveMovieNowPlaying(movieNowPlaying)
    }

    override fun clearAllMovies(): Completable {
        return movieLocalRepo.clearAllMovies()
    }

    override fun saveMoviesNowPlaying(moviesNowPlaying: List<MovieNowPlayingDataEntity>): Completable {
        return movieLocalRepo.saveMoviesNowPlaying(moviesNowPlaying).doOnComplete{
            movieLocalRepo.setLastCacheTime(System.currentTimeMillis())
            movieLocalRepo.setLastCacheTimeMoviesNowPlaying(System.currentTimeMillis())
        }
    }

    override fun clearMoviesNowPlaying(): Completable {
        return movieLocalRepo.clearMoviesNowPlaying()
    }

    override fun getMoviesNowPlaying(page: Int, language: String): Single<List<MovieNowPlayingDataEntity>> {
        return movieLocalRepo.getMoviesNowPlaying(page, language)
    }

    override fun getMovieNowPlaying(id: Long): Single<MovieNowPlayingDataEntity> {
        return movieLocalRepo.getMovieNowPlaying(id)
    }
}