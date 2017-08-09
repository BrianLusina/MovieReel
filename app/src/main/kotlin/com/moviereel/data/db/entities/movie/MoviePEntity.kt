package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author lusinabrian on 15/05/17.
 * *
 * @Notes Popular Movie Model (POJO) that will be mapped to a row in the table movie_popular
 * * in the database
 */
@Entity(tableName = "movie_popular")
data class MoviePEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Long = 0,

        @ColumnInfo(name = "adult")
        var adult: Boolean = false,

        @ColumnInfo(name = "poster_path")
        var posterPath: String,

        @ColumnInfo(name = "overview")
        var overview: String,

        @ColumnInfo(name = "original_language")
        var originalLanguage: String,

        @ColumnInfo(name = "backdrop_path")
        var backdropPath: String,

        @ColumnInfo(name = "video")
        var video: Boolean,
        @ColumnInfo(name = "vote_count")
        var voteCount: Int = 0,

        @ColumnInfo(name = "vote_average")
        var voteAverage: Float,
        @ColumnInfo(name = "popularity")
        var popularity: Float,
        @ColumnInfo(name = "release_date")
        var releaseDate: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "original_title")
        var originalTitle: String
)
