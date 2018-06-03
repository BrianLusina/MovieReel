package com.moviereel.cache.movies

import com.moviereel.cache.movies.nowplaying.NowPlaying
import io.reactivex.Completable

/**
 * @author lusinabrian on 03/06/18.
 * @Notes Movie cache interface
 */
interface MovieCache : NowPlaying {
    fun clearAllMovies() : Completable
}