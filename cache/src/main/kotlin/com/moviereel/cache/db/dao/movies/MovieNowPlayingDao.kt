package com.moviereel.cache.db.dao.movies

import android.arch.persistence.room.*
import com.moviereel.cache.db.dao.QUERY_GET_ALL
import com.moviereel.cache.db.entities.movie.MovieNowPlayingCacheEntity
import io.reactivex.Flowable


/**
 * @author lusinabrian on 08/08/17.
 * @Notes Dao for Movie Now Playing
 */
@Dao
interface MovieNowPlayingDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieNp(movieNowPlayingCacheEntity: MovieNowPlayingCacheEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieNpList(vararg movieNowPlayingCacheEntity: MovieNowPlayingCacheEntity)

    // ****************** READ ************************
    @Query("$QUERY_GET_ALL movie_now_playing")
    fun getAllMoviesNowPlaying(): Flowable<List<MovieNowPlayingCacheEntity>>

    @Query("$QUERY_GET_ALL movie_now_playing where id = :movieNpId")
    fun getMovieNpById(movieNpId: Long): Flowable<MovieNowPlayingCacheEntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieNpList(vararg movieNowPlayingDomainEntity: MovieNowPlayingCacheEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovieNp(movieNowPlayingDomainEntity: MovieNowPlayingCacheEntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieNp(movieNowPlayingDomainEntity: MovieNowPlayingCacheEntity)

}