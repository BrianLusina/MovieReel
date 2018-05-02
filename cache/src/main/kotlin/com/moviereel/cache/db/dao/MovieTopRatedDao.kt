package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.domain.models.movies.MovieTopRatedModel
import io.reactivex.Flowable

/**
 * @author lusinabrian on 18/09/17.
 * @Notes Top rated movie dao
 */
@Dao
interface MovieTopRatedDao {
    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieTopRated(vararg movieTopRatedEntity: MovieTopRatedModel)

    // ****************** READ ************************
    @Query("select * from movie_top_rated")
    fun getAllMoviesTopRated(): Flowable<List<MovieTopRatedModel>>

    @Query("select * from movie_top_rated where id = :id")
    fun getMovieTopRatedById(id: Long): Flowable<MovieTopRatedModel>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieTopRated(vararg movieTopRatedEntity: MovieTopRatedModel)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieTopRated(movieTopRatedEntity: MovieTopRatedModel)

}