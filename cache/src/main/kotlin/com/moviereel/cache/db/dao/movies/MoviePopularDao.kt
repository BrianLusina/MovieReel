package com.moviereel.cache.db.dao.movies

import android.arch.persistence.room.*
import com.moviereel.cache.db.models.movie.MoviePopularCacheEntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 16/09/17.
 * @Notes DAO for popular movies
 */
@Dao
interface MoviePopularDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviePopular(vararg moviePopularEntity: MoviePopularCacheEntity)

    // ****************** READ ************************
    @Query("select * from movie_popular")
    fun getAllMoviesPopular(): Flowable<List<MoviePopularCacheEntity>>

    @Query("select * from movie_popular where id = :moviePopularId")
    fun getMoviePopularById(moviePopularId: Long): Flowable<MoviePopularCacheEntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMoviePopular(vararg movieNPEntity: MoviePopularCacheEntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMoviePopular(moviePopularEntity: MoviePopularCacheEntity)

}