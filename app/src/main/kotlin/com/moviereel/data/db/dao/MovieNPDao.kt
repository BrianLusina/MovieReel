package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.data.db.entities.movie.MovieNPEntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 08/08/17.
 * @Notes Dao for Movie Now Playing
 */
@Dao
interface MovieNPDao {

    @Query("select * from movie_now_playing")
    fun getAllMoviesNowPlaying(): Flowable<List<MovieNPEntity>>

    @Query("select * from movie_now_playing where id = :movieNpId")
    fun getMovieNpById(movieNpId: Long): Flowable<MovieNPEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieNp(movieNPEntity: MovieNPEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovieNp(movieNPEntity: MovieNPEntity)

    @Delete
    fun deleteMovieNp(movieNPEntity: MovieNPEntity)

}