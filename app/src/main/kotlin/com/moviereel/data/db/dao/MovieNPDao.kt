package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.data.db.entities.movie.MovieNowPlayingEntity
import io.reactivex.Flowable


/**
 * @author lusinabrian on 08/08/17.
 * @Notes Dao for Movie Now Playing
 */
@Dao
interface MovieNPDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieNp(movieNowPlayingEntity: MovieNowPlayingEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieNpList(vararg movieNowPlayingEntity: MovieNowPlayingEntity)

    // ****************** READ ************************
    @Query("select * from movie_now_playing")
    fun getAllMoviesNowPlaying(): Flowable<List<MovieNowPlayingEntity>>

    @Query("select * from movie_now_playing where id = :movieNpId")
    fun getMovieNpById(movieNpId: Long): Flowable<MovieNowPlayingEntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieNpList(vararg movieNowPlayingEntity: MovieNowPlayingEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovieNp(movieNowPlayingEntity: MovieNowPlayingEntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieNp(movieNowPlayingEntity: MovieNowPlayingEntity)

}