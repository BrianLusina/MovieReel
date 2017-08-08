package com.moviereel.data.repositories.movierepo

import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.api.model.movie.response.MovieNowPlayingResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import io.reactivex.Observable

/**
 * @author lusinabrian on 08/08/17.
 * @Notes Common methods that will be used for the repositories will be found here.
 * This will enable a greater deal of abstraction and as well as remove DRY principle(s)
 */
interface MovieDataSource {

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently
     * now playing
     * @param remote whether to fetch this from a remote repo or not
     * @return [MovieNowPlayingResponse] response to return from the api call
     * */
    fun getMoviesNowPlaying(remote: Boolean = true, page: Int, language: String): Observable<MovieNowPlayingResponse>

    /**
     * API call to get the latest movies being shown
     * @param remote whether to fetch this from a remote repo or not
     * */
    fun doGetMoviesLatest(remote: Boolean = true, language: String): Observable<BaseResultsResponse.MovieLatestResponse>

    /**
     * Does an api call to get a list of popular movies
     * @param remote whether to fetch this from a remote repo or not
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    fun doGetMoviesPopular(remote: Boolean = false, page: Int, language: String): Observable<MoviePopularResponse>

}