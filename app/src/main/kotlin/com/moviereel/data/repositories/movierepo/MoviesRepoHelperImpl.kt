package com.moviereel.data.repositories.movierepo

import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.data.repositories.movierepo.local.MoviesLocalDataSource
import com.moviereel.data.repositories.movierepo.remote.MoviesRemoteDataSource
import io.reactivex.Flowable
import io.reactivex.Observable
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

    override fun getMoviesNowPlaying(remote: Boolean?, page: Int, language: String): Flowable<List<MovieNPEntity>> {
        if (remote!!) {
            val data = moviesRemoteDataSource.getMoviesNowPlaying(page = page, language = language)
            // save data to disk
            movieLocalDataSource.saveMoviesNowPlayingOffline(data)
            return data
        } else
            return movieLocalDataSource.getMoviesNowPlaying(false, page, language)
    }


    override fun doGetMoviesLatest(remote: Boolean, language: String): Observable<BaseResultsResponse.MovieLatestResponse> {
        return if (remote)
            moviesRemoteDataSource.doGetMoviesLatest(language = language)
        else
            movieLocalDataSource.doGetMoviesLatest(false, language)
    }

    override fun doGetMoviesPopular(remote: Boolean, page: Int, language: String): Observable<MoviePopularResponse> {
        return if (remote)
            moviesRemoteDataSource.doGetMoviesPopular(page = page, language = language)
        else
            movieLocalDataSource.doGetMoviesPopular(false, page, language)
    }
}