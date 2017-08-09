package com.moviereel.data.db.dao

import android.arch.persistence.room.*
import com.moviereel.data.db.entities.GenreEntity
import io.reactivex.Flowable

/**
 * @author lusinabrian on 09/08/17.
 * @Notes Data Access Object for a single Genre
 */
@Dao
interface GenreDao {

    // **************** CREATE ***********************
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenre(genreEntity: GenreEntity)

    @Insert
    fun insertGenreList(vararg genreEntity: GenreEntity)

    // ****************** READ *********************
    @Query("SELECT * FROM genre_ids")
    fun getAllGenres(): Flowable<List<GenreEntity>>

    @Query("select * from genre_ids where id = :genreId")
    fun getGenreById(genreId: Long): Flowable<GenreEntity>

    // ***************** UPDATE **********************
    @Update
    fun updateGenre(genreEntity: GenreEntity)

    @Update
    fun updateGenreList(vararg genreEntity: GenreEntity)

    // ***************** DELETE ********************
    @Delete
    fun deleteGenre(genreEntity: GenreEntity)
}