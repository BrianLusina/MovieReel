package com.moviereel.cache.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.moviereel.cache.db.dao.movies.MovieNowPlayingDao
import com.moviereel.cache.db.dao.movies.MoviePopularDao
import com.moviereel.cache.db.dao.movies.MovieTopRatedDao
import com.moviereel.cache.db.dao.movies.MovieUpcomingDao
import com.moviereel.cache.db.models.movie.MovieNowPlayingCacheModel
import com.moviereel.domain.models.GenreModel
import com.moviereel.domain.models.movies.MoviePopularModel
import com.moviereel.domain.models.movies.MovieTopRatedModel
import com.moviereel.domain.models.movies.MovieUpcomingModel

/**
 * @author lusinabrian on 28/03/17
 */

@Database(entities = [
    (MovieNowPlayingCacheModel::class), (MoviePopularModel::class),
    (MovieTopRatedModel::class), (MovieUpcomingModel::class), (GenreModel::class)],
        version = 1, exportSchema = false)
@TypeConverters(DbConverters::class)
abstract class MovieReelDatabase : RoomDatabase() {

    abstract fun getMovieNowPlayingDao(): MovieNowPlayingDao

    abstract fun getMoviePopularDao(): MoviePopularDao

    abstract fun getMovieTopRatedDao(): MovieTopRatedDao

    abstract fun getMovieUpcomingDao(): MovieUpcomingDao
}
