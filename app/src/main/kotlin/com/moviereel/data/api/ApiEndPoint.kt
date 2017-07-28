package com.moviereel.data.api

import com.moviereel.BuildConfig

/**
 * @author lusinabrian on 28/03/17
 * * Will hold data/constants for accessing the api endpoints
 * *
 */

internal object ApiEndPoint {

    // movie endpoints
    val ENDPOINT_MOVIE_NOW_PLAYING = BuildConfig.BASE_URL + "movie/now_playing"
    val ENDPOINT_MOVIE_LATEST = BuildConfig.BASE_URL + "movie/latest"
    val ENDPOINT_MOVIE_POPULAR = BuildConfig.BASE_URL + "movie/popular"
    val ENDPOINT_MOVIE_TOP_RATED = BuildConfig.BASE_URL + "movie/top_rated"
    val ENDPOINT_MOVIE_UPCOMING = BuildConfig.BASE_URL + "movie/upcoming"

    // tv endpoints
    val ENDPOINT_TV_TOP_RATED = BuildConfig.BASE_URL + "tv/top_rated"
    val ENDPOINT_TV_ON_THE_AIR = BuildConfig.BASE_URL + "tv/on_the_air"
    val ENDPOINT_TV_AIRING_TODAY = BuildConfig.BASE_URL + "tv/airing_today"
    val ENDPOINT_TV_POPULAR = BuildConfig.BASE_URL + "tv/popular"
    val ENDPOINT_TV_LATEST = BuildConfig.BASE_URL + "tv/latest"
}//this class is not publicly instantiable
