package com.moviereel.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.moviereel.data.db.dao.MovieNPDao
import com.moviereel.data.db.dao.MoviePopularDao
import com.moviereel.data.db.entities.GenreEntity
import com.moviereel.data.db.entities.movie.*

/**
 * @author lusinabrian on 28/03/17
 */

@Database(entities = arrayOf(
        MovieNPEntity::class, MovieLatestEntity::class, MoviePEntity::class,
        MovieTREntity::class, MovieUEntity::class, GenreEntity::class),
        version = 1,
        exportSchema = false)
@TypeConverters(DbConverters::class)
abstract class MovieReelDatabase : RoomDatabase(){

    abstract fun getMovieNowPlayingDao() : MovieNPDao

    abstract fun getMoviePopularDao() : MoviePopularDao
}
