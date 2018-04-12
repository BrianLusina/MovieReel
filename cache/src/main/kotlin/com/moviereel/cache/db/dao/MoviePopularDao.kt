package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.data.db.entities.movie.MoviePopularEntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 16/09/17.
 * @Notes DAO for popular movies
 */
@Dao
interface MoviePopularDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviePopular(vararg moviePopularEntity: MoviePopularEntity)

    // ****************** READ ************************
    @Query("select * from movie_popular")
    fun getAllMoviesPopular(): Flowable<List<MoviePopularEntity>>

    @Query("select * from movie_popular where id = :moviePopularId")
    fun getMoviePopularById(moviePopularId: Long): Flowable<MoviePopularEntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMoviePopular(vararg movieNPEntity: MoviePopularEntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMoviePopular(moviePopularEntity: MoviePopularEntity)

}