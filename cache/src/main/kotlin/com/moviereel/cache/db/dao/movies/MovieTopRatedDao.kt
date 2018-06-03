package com.moviereel.cache.db.dao.movies

import android.arch.persistence.room.*
import com.moviereel.cache.db.models.movie.MovieTopRatedCacheEntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 18/09/17.
 * @Notes Top rated movie dao
 */
@Dao
interface MovieTopRatedDao {
    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieTopRated(vararg movieTopRatedEntity: MovieTopRatedCacheEntity)

    // ****************** READ ************************
    @Query("select * from movie_top_rated")
    fun getAllMoviesTopRated(): Flowable<List<MovieTopRatedCacheEntity>>

    @Query("select * from movie_top_rated where id = :id")
    fun getMovieTopRatedById(id: Long): Flowable<MovieTopRatedCacheEntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMovieTopRated(vararg movieTopRatedEntity: MovieTopRatedCacheEntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMovieTopRated(movieTopRatedEntity: MovieTopRatedCacheEntity)

}