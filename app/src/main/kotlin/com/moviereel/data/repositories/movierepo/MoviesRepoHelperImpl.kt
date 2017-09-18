package com.moviereel.data.repositories.movierepo

import com.moviereel.data.db.entities.movie.MovieLatestEntity
import com.moviereel.data.db.entities.movie.MovieNowPlayingEntity
import com.moviereel.data.db.entities.movie.MoviePopularEntity
import com.moviereel.data.db.entities.movie.MovieTopRatedEntity
import com.moviereel.data.repositories.movierepo.local.MoviesLocalDataSource
import com.moviereel.data.repositories.movierepo.remote.MoviesRemoteDataSource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 08/08/17.
 * @Notes Implementation for repository for movies
 */
@Singleton
class MoviesRepoHelperImpl
@Inject
constructor(val movieLocalDataSource: MoviesLocalDataSource,
            val moviesRemoteDataSource: MoviesRemoteDataSource) : MoviesRepoHelper {

    override fun getMoviesNowPlaying(remote: Boolean?, page: Int, language: String): Flowable<List<MovieNowPlayingEntity>> {
        return if (remote!!) {
            val data = moviesRemoteDataSource.getMoviesNowPlaying(page = page, language = language)
            // save data to disk
            movieLocalDataSource.saveMoviesNowPlayingOffline(data)
            data
        } else
            movieLocalDataSource.getMoviesNowPlaying(false, page, language)
    }


    override fun doGetMoviesLatest(remote: Boolean, language: String): Flowable<MovieLatestEntity> {
        return if (remote)
            moviesRemoteDataSource.doGetMoviesLatest(language = language)
        else
            movieLocalDataSource.doGetMoviesLatest(false, language)
    }

    override fun doGetMoviesPopular(remote: Boolean, page: Int, language: String): Flowable<List<MoviePopularEntity>> {
        return if (remote) {
            val data = moviesRemoteDataSource.doGetMoviesPopular(page = page, language = language)
            movieLocalDataSource.savePopularMoviesToDb(data)
            data
        } else {
            movieLocalDataSource.doGetMoviesPopular(false, page, language)
        }
    }

    /**
     * Get top rated movies
     * */
    override fun doGetMoviesTopRated(remote: Boolean, page: Int, language: String, region: String): Flowable<List<MovieTopRatedEntity>> {
        return if (remote) {
            val data = moviesRemoteDataSource.doGetMoviesTopRated(page = page, language = language,
                    region = region)
            movieLocalDataSource.saveTopRatedMoviesToDb(data)
            data
        } else {
            movieLocalDataSource.doGetMoviesTopRated(false, page, language, region)
        }
    }
}