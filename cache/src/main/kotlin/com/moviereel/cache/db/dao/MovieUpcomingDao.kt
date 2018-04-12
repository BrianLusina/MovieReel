package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.data.db.entities.movie.MovieUpcomingEntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 26/09/17.
 * @Notes
 */
@Dao
interface MovieUpcomingDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieUpcoming(vararg movieUpcomingEntity: MovieUpcomingEntity)

    // ****************** READ ************************
    @Query("select * from movie_upcoming")
    fun getAllMoviesUpcoming(): Flowable<List<MovieUpcomingEntity>>

    @Query("select * from movie_upcoming where id = :id")
    fun getMovieUpcomingById(id: Long): Flowable<MovieUpcomingEntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieUpcoming(vararg movieUpcomingEntity: MovieUpcomingEntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieUpcoming(movieUpcomingEntity: MovieUpcomingEntity)
}