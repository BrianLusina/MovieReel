package com.moviereel.data.repositories.movierepo.remote

import com.moviereel.data.api.ApiRetrofitService
import com.moviereel.data.api.model.movie.MovieNowPlayingResponse
import com.moviereel.data.api.model.movie.MoviePopularResponse
import com.moviereel.data.db.entities.movie.MovieLatestEntity
import com.moviereel.data.db.entities.movie.MovieNowPlayingEntity
import com.moviereel.data.db.entities.movie.MoviePopularEntity
import com.moviereel.data.db.entities.movie.MovieTopRatedEntity
import com.moviereel.data.repositories.movierepo.MovieDataSource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 08/08/17.
 * @Notes Remote data source for movies
 */

@Singleton
class MoviesRemoteDataSource
@Inject
constructor(val mApiRetrofitService: ApiRetrofitService) : MovieDataSource {

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently now playing
     * @return [MovieNowPlayingResponse] response to return from the api call
     */
    override fun getMoviesNowPlaying(remote: Boolean?, page: Int, language: String): Flowable<List<MovieNowPlayingEntity>> {
        val data = mApiRetrofitService.getMoviesNowPlaying(language, page)
        return data.flatMap({ Flowable.just(it.results) })
    }

    /**
     * API call to get the latest movies being shown*/
    override fun doGetMoviesLatest(remote: Boolean, language: String): Flowable<MovieLatestEntity> {
        return mApiRetrofitService.doGetMoviesLatest(language)
    }

    /**
     * Does an api call to get a list of popular movies
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    override fun doGetMoviesPopular(remote: Boolean, page: Int, language: String):
            Flowable<List<MoviePopularEntity>> {
        val popularMovieData = mApiRetrofitService.doGetMoviesPopular(page, language)
        return popularMovieData.flatMap { Flowable.just(it.results) }
    }

    override fun doGetMoviesTopRated(remote: Boolean, page: Int, language: String, region: String): Flowable<List<MovieTopRatedEntity>> {
        val topRatedMovieData = mApiRetrofitService.doGetMoviesTopRated(page, language, region)
        return topRatedMovieData.flatMap { Flowable.just(it.results) }
    }
}