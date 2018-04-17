package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.domain.models.movies.MoviePopularModel
import io.reactivex.Flowable

/**
 * @author lusinabrian on 16/09/17.
 * @Notes DAO for popular movies
 */
@Dao
interface MoviePopularDao {

    // ****************** CREATE ************************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviePopular(vararg moviePopularEntity: MoviePopularModel)

    // ****************** READ ************************
    @Query("select * from movie_popular")
    fun getAllMoviesPopular(): Flowable<List<MoviePopularModel>>

    @Query("select * from movie_popular where id = :moviePopularId")
    fun getMoviePopularById(moviePopularId: Long): Flowable<MoviePopularModel>

    // ****************** UPDATE ************************

    @Update
    fun updateMoviePopular(vararg movieNPEntity: MoviePopularModel)

    // ****************** DELETE ************************

    @Delete
    fun deleteMoviePopular(moviePopularEntity: MoviePopularModel)

}