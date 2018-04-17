package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import io.reactivex.Flowable


/**
 * @author lusinabrian on 08/08/17.
 * @Notes Dao for Movie Now Playing
 */
@Dao
interface MovieNowPlayingDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieNp(movieNowPlayingEntity: MovieNowPlayingModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieNpList(vararg movieNowPlayingEntity: MovieNowPlayingModel)

    // ****************** READ ************************
    @Query("select * from movie_now_playing")
    fun getAllMoviesNowPlaying(): Flowable<List<MovieNowPlayingModel>>

    @Query("select * from movie_now_playing where id = :movieNpId")
    fun getMovieNpById(movieNpId: Long): Flowable<MovieNowPlayingModel>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieNpList(vararg movieNowPlayingEntity: MovieNowPlayingModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovieNp(movieNowPlayingEntity: MovieNowPlayingModel)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieNp(movieNowPlayingEntity: MovieNowPlayingModel)

}