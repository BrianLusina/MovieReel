package com.moviereel.data.api

import com.moviereel.data.api.model.movie.request.MovieLatestRequest
import com.moviereel.data.api.model.movie.request.MovieNowPlayingRequest
import com.moviereel.data.api.model.movie.request.MoviePopularRequest
import com.moviereel.data.api.model.movie.request.MovieTopRatedRequest
import com.moviereel.data.api.model.movie.request.MovieUpcomingRequest
import com.moviereel.data.api.model.movie.response.MovieLatestResponse
import com.moviereel.data.api.model.movie.response.MovieNowPlayingResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import com.moviereel.data.api.model.movie.response.MovieTopRatedResponse
import com.moviereel.data.api.model.movie.response.MovieUpcomingResponse
import com.moviereel.data.api.model.tv.request.TvAiringTodayRequest
import com.moviereel.data.api.model.tv.request.TvLatestRequest
import com.moviereel.data.api.model.tv.request.TvOnTheAirRequest
import com.moviereel.data.api.model.tv.request.TvPopularRequest
import com.moviereel.data.api.model.tv.request.TvTopRatedRequest
import com.moviereel.data.api.model.tv.response.TvAiringTodayResponse
import com.moviereel.data.api.model.tv.response.TvLatestResponse
import com.moviereel.data.api.model.tv.response.TvOnTheAirResponse
import com.moviereel.data.api.model.tv.response.TvPopularResponse
import com.moviereel.data.api.model.tv.response.TvTopRatedResponse
import com.rx2androidnetworking.Rx2AndroidNetworking

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable

/**
 * @author lusinabrian on 28/03/17
 * * Handles API calls to server/API to fetch data on related movie data. This will abstract all the logic
 * * from the UI and will be handled here,
 * * todo: Update to allow quering of data that is on subsequent pages 2, 3, etc
 * * todo: allow changing of language when fetching data, preferabbly to be set in shared prefs
 * * todo: allow quering of tvs and movies by region as well
 */

@Singleton
class ApiHelperImpl @Inject
constructor(
        /**
         * returns the [ApiHeader]
         */
        val mApiHeader: ApiHeader) : ApiHelper {
    
    override fun getApiHeader(): ApiHeader {
        return mApiHeader
    }

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently now playing

     * @param request the request to pass to the api
     * *
     * @return [MovieNowPlayingResponse] response to get now playing movies
     */
    override fun doGetMoviesNowPlayingApiCall(request: MovieNowPlayingRequest): Observable<MovieNowPlayingResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIE_NOW_PLAYING)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .addQueryParameter(request)
                .build()
                .getObjectObservable(MovieNowPlayingResponse::class.java)
    }

    /**
     * API call to get the latest movies being shown
     * @param request request to make
     */
    override fun doGetMoviesLatestApiCall(request: MovieLatestRequest): Observable<MovieLatestResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIE_LATEST)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .addQueryParameter(request)
                .build()
                .getObjectObservable(MovieLatestResponse::class.java)
    }

    /**
     * Does an api call to get a list of popular movies

     * @param request Request to make to fetch popular movies
     * *
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    override fun doGetMoviesPopularApiCall(request: MoviePopularRequest): Observable<MoviePopularResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIE_POPULAR)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .addQueryParameter(request)
                .build()
                .getObjectObservable(MoviePopularResponse::class.java)
    }

    /**
     * Makes an api call to fetch the top rated movies

     * @param request request that is made to the api
     * *
     * @return [MovieTopRatedResponse] what we get back from the api as an object
     */
    override fun doGetMoviesTopRatedApiCall(request: MovieTopRatedRequest): Observable<MovieTopRatedResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIE_TOP_RATED)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .addQueryParameter(request)
                .build()
                .getObjectObservable(MovieTopRatedResponse::class.java)
    }

    /**
     * Makes an API call to get upcoming movies

     * @param request Request to make to fetch upcoming movies
     * *
     * @return [MovieUpcomingResponse] what we get back when we request for upcoming movies
     */
    override fun doGetMoviesUpcomingApiCall(request: MovieUpcomingRequest): Observable<MovieUpcomingResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIE_UPCOMING)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .addQueryParameter(request)
                .build()
                .getObjectObservable(MovieUpcomingResponse::class.java)
    }

    /**
     * Get a list of all the top rated tv shows on TMDB

     * @param ratedRequest the request to send out to get the top rated tv shows
     */
    override fun doGetTvTopRatedApiCall(ratedRequest: TvTopRatedRequest): Observable<TvTopRatedResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_TOP_RATED)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .addQueryParameter(ratedRequest)
                .build()
                .getObjectObservable(TvTopRatedResponse::class.java)
    }

    /**
     * get popular tv shows

     * @param tvPopularRequest request to fetch for popular tv shows
     */
    override fun doGetTvPopularApiCall(tvPopularRequest: TvPopularRequest): Observable<TvPopularResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_POPULAR)
                .addQueryParameter(tvPopularRequest)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .build()
                .getObjectObservable(TvPopularResponse::class.java)
    }

    /**
     * Get the tv shows that are on the air currently

     * @param tvOnTheAirRequest request for getting tv shows that are currently on the air
     */
    override fun doGetTvOnTheAirApiCall(tvOnTheAirRequest: TvOnTheAirRequest): Observable<TvOnTheAirResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_ON_THE_AIR)
                .addQueryParameter(tvOnTheAirRequest)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .build()
                .getObjectObservable(TvOnTheAirResponse::class.java)
    }

    /**
     * Get the tv shows that are airing today

     * @param tvAiringTodayRequest the request sent to the api to make the call
     * *
     * @return [&lt;TvAiringTodayResponse&gt;][Observable] object
     */
    override fun doGetTvAiringTodayApiCall(tvAiringTodayRequest: TvAiringTodayRequest): Observable<TvAiringTodayResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_AIRING_TODAY)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .addQueryParameter(tvAiringTodayRequest)
                .build()
                .getObjectObservable(TvAiringTodayResponse::class.java)
    }

    /**
     * Get the most newly created tv show. This is a live response and will continually change

     * @param tvLatestRequest the request that we will send out
     */
    override fun doGetTvLatestApiCall(tvLatestRequest: TvLatestRequest): Observable<TvLatestResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_LATEST)
                .addQueryParameter(tvLatestRequest)
                .addQueryParameter(mApiHeader.protectedApiHeader)
                .build()
                .getObjectObservable(TvLatestResponse::class.java)
    }
}
