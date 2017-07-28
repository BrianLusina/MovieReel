package com.moviereel.utils


import com.moviereel.BuildConfig

/**
 * MovieReel
 * com.moviereel.com.moviereel.utils
 * Created by lusinabrian on 26/10/16.
 * Description: Constant class containging Variables that do not change in the whole application
 */

object Constants {
    @JvmField
    val TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss"

    val MOVIE_DB_KEY = BuildConfig.MOVIE_DB_KEY
    val MOVIE_POSTER_PATH = BuildConfig.POSTER_PATH
    val MOVIE_PARCEL_KEY = "MOVIE_DATA"
    val TV_PARCEL_KEY = "TV_DATA"

    @JvmField
    val MOVIE_PREFS_FILE_NAME = "moviereel_prefs_file"

    @JvmField
    val DATABASE_NAME = "moviereel.db"
}