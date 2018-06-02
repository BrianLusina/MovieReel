package com.moviereel.cache.db.dao.movies

import android.arch.persistence.room.*
import com.moviereel.cache.db.dao.QUERY_GET_ALL
import com.moviereel.cache.db.models.movie.MovieNowPlayingCacheModel
import io.reactivex.Flowable


/**
 * @author lusinabrian on 08/08/17.
 * @Notes Dao for Movie Now Playing
 */
@Dao
interface MovieNowPlayingDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieNp(movieNowPlayingCacheEntity: MovieNowPlayingCacheModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieNpList(vararg movieNowPlayingCacheEntity: MovieNowPlayingCacheModel)

    // ****************** READ ************************
    @Query("$QUERY_GET_ALL movie_now_playing")
    fun getAllMoviesNowPlaying(): Flowable<List<MovieNowPlayingCacheModel>>

    @Query("$QUERY_GET_ALL movie_now_playing where id = :movieNpId")
    fun getMovieNpById(movieNpId: Long): Flowable<MovieNowPlayingCacheModel>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieNpList(vararg movieNowPlayingDomainEntity: MovieNowPlayingCacheModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovieNp(movieNowPlayingDomainEntity: MovieNowPlayingCacheModel)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieNp(movieNowPlayingDomainEntity: MovieNowPlayingCacheModel)

}