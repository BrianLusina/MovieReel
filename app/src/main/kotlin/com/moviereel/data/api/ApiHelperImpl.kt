package com.moviereel.data.api

import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.api.model.movie.response.MovieNowPlayingResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 28/03/17
 * * Handles API calls to server/API to fetch data on related movie data. This will abstract all the logic
 * * from the UI and will be handled here,
 * * todo: Update to allow quering of data that is on subsequent pages 2, 3, etc
 * * todo: allow changing of language when fetching data, preferabbly to be set in shared prefs
 * * todo: allow quering of tvs and movies by region as well
 */

@Singleton
class ApiHelperImpl
@Inject
constructor(val mApiHeader: ApiHeader, val mApiRetrofitService: ApiRetrofitService) : ApiHelper {

    override fun getApiHeader(): ApiHeader {
        return mApiHeader
    }

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently now playing

     * @param request the request to pass to the api
     * @return [MovieNowPlayingResponse] response to get now playing movies
     */
    override fun getMoviesNowPlayingApiCall(page: Int, language: String): Observable<MovieNowPlayingResponse> {
        return mApiRetrofitService.getMoviesNowPlaying(
                createQueryMap(page, language)
                /*hashMapOf("language" to language),
                hashMapOf("page" to page)*/
        )
    }

    fun <T> createQueryMap(vararg queryList : T): Map<String, T> {
        val result = mutableMapOf<String, T>()
        for (query in queryList){
            when(query){
                is String -> result.put("language", query)
                is Number -> result.put("page", query)
            }
        }
        return result
    }

    /*** API call to get the latest movies being shown*/
    override fun doGetMoviesLatestApiCall(language: String): Observable<BaseResultsResponse.MovieLatestResponse> {
        return mApiRetrofitService.doGetMoviesLatestApiCall(
                hashMapOf("language" to language)
        )
    }

    /**
     * Does an api call to get a list of popular movies
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    override fun doGetMoviesPopularApiCall(page: Int, language: String): Observable<MoviePopularResponse> {
        return mApiRetrofitService.doGetMoviesPopularApiCall(
                hashMapOf("page" to page),
                hashMapOf("language" to language)
        )
    }


//
//    /**
//     * Makes an api call to fetch the top rated movies
//
//     * @param request request that is made to the api
//     * *
//     * @return [MovieTopRatedResponse] what we get back from the api as an object
//     */
//    override fun doGetMoviesTopRatedApiCall(request: MovieTopRatedRequest): Observable<MovieTopRatedResponse> {
//        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIE_TOP_RATED)
//                .addQueryParameter(mApiHeader.protectedApiHeader)
//                .addQueryParameter(request)
//                .build()
//                .getObjectObservable(MovieTopRatedResponse::class.java)
//    }
//
//    /**
//     * Makes an API call to get upcoming movies
//
//     * @param request Request to make to fetch upcoming movies
//     * *
//     * @return [MovieUpcomingResponse] what we get back when we request for upcoming movies
//     */
//    override fun doGetMoviesUpcomingApiCall(request: MovieUpcomingRequest): Observable<MovieUpcomingResponse> {
//        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIE_UPCOMING)
//                .addQueryParameter(mApiHeader.protectedApiHeader)
//                .addQueryParameter(request)
//                .build()
//                .getObjectObservable(MovieUpcomingResponse::class.java)
//    }
//
//    /**
//     * Get a list of all the top rated tv shows on TMDB
//
//     * @param ratedRequest the request to send out to get the top rated tv shows
//     */
//    override fun doGetTvTopRatedApiCall(ratedRequest: TvTopRatedRequest): Observable<TvTopRatedResponse> {
//        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_TOP_RATED)
//                .addQueryParameter(mApiHeader.protectedApiHeader)
//                .addQueryParameter(ratedRequest)
//                .build()
//                .getObjectObservable(TvTopRatedResponse::class.java)
//    }
//
//    /**
//     * get popular tv shows
//
//     * @param tvPopularRequest request to fetch for popular tv shows
//     */
//    override fun doGetTvPopularApiCall(tvPopularRequest: TvPopularRequest): Observable<TvPopularResponse> {
//        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_POPULAR)
//                .addQueryParameter(tvPopularRequest)
//                .addQueryParameter(mApiHeader.protectedApiHeader)
//                .build()
//                .getObjectObservable(TvPopularResponse::class.java)
//    }
//
//    /**
//     * Get the tv shows that are on the air currently
//
//     * @param tvOnTheAirRequest request for getting tv shows that are currently on the air
//     */
//    override fun doGetTvOnTheAirApiCall(tvOnTheAirRequest: TvOnTheAirRequest): Observable<TvOnTheAirResponse> {
//        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_ON_THE_AIR)
//                .addQueryParameter(tvOnTheAirRequest)
//                .addQueryParameter(mApiHeader.protectedApiHeader)
//                .build()
//                .getObjectObservable(TvOnTheAirResponse::class.java)
//    }
//
//    /**
//     * Get the tv shows that are airing today
//
//     * @param tvAiringTodayRequest the request sent to the api to make the call
//     * *
//     * @return [&lt;TvAiringTodayResponse&gt;][Observable] object
//     */
//    override fun doGetTvAiringTodayApiCall(tvAiringTodayRequest: TvAiringTodayRequest): Observable<TvAiringTodayResponse> {
//        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_AIRING_TODAY)
//                .addQueryParameter(mApiHeader.protectedApiHeader)
//                .addQueryParameter(tvAiringTodayRequest)
//                .build()
//                .getObjectObservable(TvAiringTodayResponse::class.java)
//    }
//
//    /**
//     * Get the most newly created tv show. This is a live response and will continually change
//
//     * @param tvLatestRequest the request that we will send out
//     */
//    override fun doGetTvLatestApiCall(tvLatestRequest: TvLatestRequest): Observable<TvLatestResponse> {
//        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TV_LATEST)
//                .addQueryParameter(tvLatestRequest)
//                .addQueryParameter(mApiHeader.protectedApiHeader)
//                .build()
//                .getObjectObservable(TvLatestResponse::class.java)
//    }
}
