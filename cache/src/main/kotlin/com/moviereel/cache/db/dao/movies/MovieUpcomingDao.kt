package com.moviereel.cache.db.dao.movies

import android.arch.persistence.room.*
import com.moviereel.domain.models.movies.MovieUpcomingModel
import io.reactivex.Flowable

/**
 * @author lusinabrian on 26/09/17.
 * @Notes
 */
@Dao
interface MovieUpcomingDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieUpcoming(vararg movieUpcomingEntity: MovieUpcomingModel)

    // ****************** READ ************************
    @Query("select * from movie_upcoming")
    fun getAllMoviesUpcoming(): Flowable<List<MovieUpcomingModel>>

    @Query("select * from movie_upcoming where id = :id")
    fun getMovieUpcomingById(id: Long): Flowable<MovieUpcomingModel>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieUpcoming(vararg movieUpcomingEntity: MovieUpcomingModel)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieUpcoming(movieUpcomingEntity: MovieUpcomingModel)
}