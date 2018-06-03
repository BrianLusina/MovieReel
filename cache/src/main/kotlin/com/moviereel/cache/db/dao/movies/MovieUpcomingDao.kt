package com.moviereel.cache.db.dao.movies

import android.arch.persistence.room.*
import com.moviereel.cache.db.models.movie.MovieUpcomingCacheEntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 26/09/17.
 * @Notes
 */
@Dao
interface MovieUpcomingDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieUpcoming(vararg movieUpcomingEntity: MovieUpcomingCacheEntity)

    // ****************** READ ************************
    @Query("select * from movie_upcoming")
    fun getAllMoviesUpcoming(): Flowable<List<MovieUpcomingCacheEntity>>

    @Query("select * from movie_upcoming where id = :id")
    fun getMovieUpcomingById(id: Long): Flowable<MovieUpcomingCacheEntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieUpcoming(vararg movieUpcomingEntity: MovieUpcomingCacheEntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieUpcoming(movieUpcomingEntity: MovieUpcomingCacheEntity)
}