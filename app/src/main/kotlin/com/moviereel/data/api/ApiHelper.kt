package com.moviereel.data.api

import com.moviereel.data.api.model.BaseResultsResponse.*
import com.moviereel.data.api.model.movie.response.MovieNowPlayingResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import com.moviereel.data.api.model.tv.response.*
import io.reactivex.Observable

/**
 * @author lusinabrian on 29/07/17.
 * @Notes
 * Interface that will interact with the API and make get and post requests
 * This will be an interactor that will allow presenter layer to make requests to API
 */

interface ApiHelper {
    /**
     * gets the [ApiHeader] which will be used when making requests
     * @return [ApiHeader]
     * *
     */
    fun getApiHeader(): ApiHeader

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently
     * now playing
     * @return [MovieNowPlayingResponse] response to return from the api call
     * */
    fun getMoviesNowPlayingApiCall(page : Int, language : String): Observable<MovieNowPlayingResponse>

    /**
     * API call to get the latest movies being shown
     * */
    fun doGetMoviesLatestApiCall(language: String): Observable<MovieLatestResponse>

    /**
     * Does an api call to get a list of popular movies
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    fun doGetMoviesPopularApiCall(page: Int, language: String): Observable<MoviePopularResponse>

//    /**
//     * Makes an api call to fetch the top rated movies
//     * @return [MovieTopRatedResponse] what we get back from the api as an object
//     */
//    fun doGetMoviesTopRatedApiCall(): Observable<MovieTopRatedResponse>
//
//    /**
//     * Makes an API call to get upcoming movies
//     * @return [MovieUpcomingResponse] what we get back when we request for upcoming movies
//     */
//    fun doGetMoviesUpcomingApiCall(): Observable<MovieUpcomingResponse>
//
//    /**
//     * Get a list of all the top rated tv shows on TMDB
//     */
//    fun doGetTvTopRatedApiCall(): Observable<TvTopRatedResponse>
//
//    /**
//     * get popular tv shows
//     */
//    fun doGetTvPopularApiCall(): Observable<TvPopularResponse>
//
//    /**
//     * Get the tv shows that are on the air currently*/
//    fun doGetTvOnTheAirApiCall(): Observable<TvOnTheAirResponse>
//
//    /**
//     * Get the tv shows that are airing today
//     * *
//     * @return [<] object
//     */
//    fun doGetTvAiringTodayApiCall(): Observable<TvAiringTodayResponse>
//
//    /**
//     * Get the most newly created tv show. This is a live response and will continually change
//     */
//    fun doGetTvLatestApiCall(): Observable<TvLatestResponse>

}