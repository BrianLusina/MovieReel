package com.moviereel.data.api

import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.api.model.movie.request.MovieTopRatedRequest
import com.moviereel.data.api.model.movie.request.MovieUpcomingRequest
import com.moviereel.data.api.model.movie.response.MovieNPResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import com.moviereel.data.api.model.movie.response.MovieTopRatedResponse
import com.moviereel.data.api.model.movie.response.MovieUpcomingResponse
import com.moviereel.data.api.model.tv.request.*
import com.moviereel.data.api.model.tv.response.*
import com.moviereel.data.db.entities.GenreEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author lusinabrian on 28/03/17
 * * Interface that will interact with the API and make get and post requests
 */

interface ApiRetrofitService {

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently
     * now playing
     * @return [MovieNPResponse] response to return from the api call
     * */
    @GET(ApiEndPoint.ENDPOINT_MOVIE_NOW_PLAYING)
    fun getMoviesNowPlaying(@Query("language") language: String, @Query("page") page: Int)
            : Flowable<MovieNPResponse>

    @GET(ApiEndPoint.ENDPOINT_GENRE_MOVIE_LIST)
    fun getMovieGenreList(@Query("language") language: String) : Flowable<List<GenreEntity>>

    /*** API call to get the latest movies being shown* */
    @GET(ApiEndPoint.ENDPOINT_MOVIE_LATEST)
    fun doGetMoviesLatest(@Query("language") language: String): Observable<BaseResultsResponse.MovieLatestResponse>

    /**
     * Does an api call to get a list of popular movies
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    @GET(ApiEndPoint.ENDPOINT_MOVIE_POPULAR)
    fun doGetMoviesPopular(
            @Query("page") page: Int,
            @Query("language") language: String): Observable<MoviePopularResponse>

    /**
     * Makes an api call to fetch the top rated movies
     * @param request request that is made to the api
     * @return [MovieTopRatedResponse] what we get back from the api as an object
     */
    fun doGetMoviesTopRatedApiCall(request: MovieTopRatedRequest): Observable<MovieTopRatedResponse>

    /**
     * Makes an API call to get upcoming movies
     * @param request Request to make to fetch upcoming movies
     * *
     * @return [MovieUpcomingResponse] what we get back when we request for upcoming movies
     */
    fun doGetMoviesUpcomingApiCall(request: MovieUpcomingRequest): Observable<MovieUpcomingResponse>

    /**
     * Get a list of all the top rated tv shows on TMDB
     * @param ratedRequest the request to send out to get the top rated tv shows
     */
    fun doGetTvTopRatedApiCall(ratedRequest: TvTopRatedRequest): Observable<TvTopRatedResponse>

    /**
     * get popular tv shows
     * @param tvPopularRequest request to fetch for popular tv shows
     */
    fun doGetTvPopularApiCall(tvPopularRequest: TvPopularRequest): Observable<TvPopularResponse>

    /**
     * Get the tv shows that are on the air currently
     * @param tvOnTheAirRequest request for getting tv shows that are currently on the air
     * *
     */
    fun doGetTvOnTheAirApiCall(tvOnTheAirRequest: TvOnTheAirRequest): Observable<TvOnTheAirResponse>

    /**
     * Get the tv shows that are airing today
     * @param tvAiringTodayRequest the request sent to the api to make the call
     * *
     * @return [<] object
     */
    fun doGetTvAiringTodayApiCall(tvAiringTodayRequest: TvAiringTodayRequest): Observable<TvAiringTodayResponse>

    /**
     * Get the most newly created tv show. This is a live response and will continually change
     * @param tvLatestRequest the request that we will send out
     */
    fun doGetTvLatestApiCall(tvLatestRequest: TvLatestRequest): Observable<TvLatestResponse>
}
