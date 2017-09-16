package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.data.db.entities.movie.MoviePEntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 16/09/17.
 * @Notes DAO for popular movies
 */
@Dao
interface MoviePopularDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviePopular(vararg moviePEntity: MoviePEntity)

    // ****************** READ ************************
    @Query("select * from movie_popular")
    fun getAllMoviesPopular(): Flowable<List<MoviePEntity>>

    @Query("select * from movie_popular where id = :moviePopularId")
    fun getMoviePopularById(moviePopularId: Long): Flowable<MoviePEntity>

    // ****************** UPDATE ************************

    @Update
    fun updateMoviePopular(vararg movieNPEntity: MoviePEntity)

    // ****************** DELETE ************************

    @Delete
    fun deleteMoviePopular(moviePEntity: MoviePEntity)

}