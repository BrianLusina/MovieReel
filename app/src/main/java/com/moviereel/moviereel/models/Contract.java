package com.moviereel.moviereel.models;

import com.moviereel.moviereel.BuildConfig;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel.Contracts
 * Created by lusinabrian on 05/09/16 at 12:45
 * <p/>
 * Description: contains constants for the MovieDB api
 */
public class Contract {
    /*Movie enpoints*/
    public static final String MOVIE_DB_KEY = BuildConfig.MOVIE_DB_KEY;
    public static final String BASE_URL = BuildConfig.BASE_URL;
    public static final String NOW_PLAYING = BASE_URL + BuildConfig.NOW_PLAYING + MOVIE_DB_KEY;
    public static final String POPULAR_MOVIES = BASE_URL + BuildConfig.POPULAR_MOVIES + MOVIE_DB_KEY;
    public static final String TOP_RATED = BASE_URL + BuildConfig.TOP_RATED + MOVIE_DB_KEY;
    public static final String UPCOMING = BASE_URL + BuildConfig.UPCOMING + MOVIE_DB_KEY;
    public static final String LATEST_MOVIE = BASE_URL + BuildConfig.LATEST_MOVIE+ MOVIE_DB_KEY;
    public static final String MOVIE_POSTER_PATH = BuildConfig.POSTER_PATH;
}
