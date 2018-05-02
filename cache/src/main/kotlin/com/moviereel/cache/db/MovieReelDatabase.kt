package com.moviereel.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.moviereel.data.db.dao.MovieNowPlayingDao
import com.moviereel.data.db.dao.MoviePopularDao
import com.moviereel.data.db.dao.MovieTopRatedDao
import com.moviereel.data.db.dao.MovieUpcomingDao
import com.moviereel.domain.models.GenreModel
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import com.moviereel.domain.models.movies.MoviePopularModel
import com.moviereel.domain.models.movies.MovieTopRatedModel
import com.moviereel.domain.models.movies.MovieUpcomingModel

/**
 * @author lusinabrian on 28/03/17
 */

@Database(entities = arrayOf(MovieNowPlayingModel::class, MoviePopularModel::class,
        MovieTopRatedModel::class, MovieUpcomingModel::class, GenreModel::class),
        version = 1, exportSchema = false)
@TypeConverters(DbConverters::class)
abstract class MovieReelDatabase : RoomDatabase() {

    abstract fun getMovieNowPlayingDao(): MovieNowPlayingDao

    abstract fun getMoviePopularDao(): MoviePopularDao

    abstract fun getMovieTopRatedDao(): MovieTopRatedDao

    abstract fun getMovieUpcomingDao(): MovieUpcomingDao
}
