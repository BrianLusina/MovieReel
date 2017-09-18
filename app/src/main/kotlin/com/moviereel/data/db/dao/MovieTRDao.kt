package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.data.db.entities.movie.MovieTopRatedEntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 18/09/17.
 * @Notes Top rated movie dao
 */
@Dao
interface MovieTRDao {
    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieTopRated(vararg movieTopRatedEntity: MovieTopRatedEntity)

    // ****************** READ ************************
    @Query("select * from movie_top_rated")
    fun getAllMoviesTopRated(): Flowable<List<MovieTopRatedEntity>>

    @Query("select * from movie_top_rated where id = :id")
    fun getMovieTopRatedById(id: Long): Flowable<MovieTopRatedEntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieTopRated(vararg movieTopRatedEntity: MovieTopRatedEntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieTopRated(movieTopRatedEntity: MovieTopRatedEntity)

}