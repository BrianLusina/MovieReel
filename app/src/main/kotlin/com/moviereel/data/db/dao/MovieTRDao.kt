package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.data.db.entities.movie.MovieTREntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 18/09/17.
 * @Notes Top rated movie dao
 */
@Dao
interface MovieTRDao {
    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieTopRated(vararg movieTREntity: MovieTREntity)

    // ****************** READ ************************
    @Query("select * from movie_top_rated")
    fun getAllMoviesTopRated(): Flowable<List<MovieTREntity>>

    @Query("select * from movie_top_rated where id = :id")
    fun getMovieTopRatedById(id: Long): Flowable<MovieTREntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieTopRated(vararg movieTrEntity: MovieTREntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieTopRated(movieTrEntity: MovieTREntity)

}