package com.moviereel.data.repositories.movierepo.remote

import com.moviereel.data.api.ApiRetrofitService
import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.api.model.movie.response.MovieNowPlayingResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import com.moviereel.data.repositories.movierepo.MovieDataSource
import io.reactivex.Observable
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
    override fun getMoviesNowPlaying(remote: Boolean, page: Int, language: String): Observable<MovieNowPlayingResponse> {
        return mApiRetrofitService.getMoviesNowPlaying(language, page)
    }

    /**
     * API call to get the latest movies being shown*/
    override fun doGetMoviesLatest(remote: Boolean, language: String): Observable<BaseResultsResponse.MovieLatestResponse> {
        return mApiRetrofitService.doGetMoviesLatest(language)
    }

    /**
     * Does an api call to get a list of popular movies
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    override fun doGetMoviesPopular(remote: Boolean, page: Int, language: String): Observable<MoviePopularResponse> {
        return mApiRetrofitService.doGetMoviesPopular(page, language)
    }
}