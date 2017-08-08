package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author lusinabrian
 * *
 * @Notes: Now playing movie model
 * *
 * * Example model we should expect to save
 * * "poster_path": "/y4MBh0EjBlMuOzv9axM4qJlmhzz.jpg",
 * * "adult": false,
 * * "overview": "The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quill's true parentage.",
 * * "releaseDate": "2017-04-24",
 * * "genre_ids": [ 35, 28, 12, 878 ],
 * * "id": 283995,
 * * "original_title": "Guardians of the Galaxy Vol. 2",
 * * "original_language": "en",
 * * "title": "Guardians of the Galaxy Vol. 2",
 * * "backdrop_path": "/aJn9XeesqsrSLKcHfHP4u5985hn.jpg",
 * * "popularity": 125.757946,
 * * "vote_count": 1437,
 * * "video": false,
 * *
 */
@Entity(tableName = "movie_now_playing")
data class MovieNPEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo(name = "movieId")
        var movieId: Int = 0,

        @ColumnInfo(name = "movieImdbId")
        var movieImdbId: String,

        @ColumnInfo(name = "name")
        var movieTitle: String,

        @ColumnInfo(name = "posterUrl")
        var moviePosterUrl: String,

        @ColumnInfo(name = "backdropUrl")
        var movieBackdropUrl: String,

        @ColumnInfo(name = "overview")
        var movieOverview: String,

        @ColumnInfo(name = "releaseDate")
        var releaseDate: String,

        @ColumnInfo(name = "homepage")
        var movieHomepage: String,

        @ColumnInfo(name = "originalLang")
        var originalLang: String,

        @ColumnInfo(name = "originalTitle")
        var originalTitle: String,

        @ColumnInfo(name = "movieStatus")
        var movieStatus: String,

        @ColumnInfo(name = "movieTagline")
        var movieTagline: String,

        @ColumnInfo(name = "movieGenres")
        var movieGenres: String,

        @ColumnInfo(name = "productionCompanies")
        var productionCompanies: String,

        @ColumnInfo(name = "productionCountries")
        var productionCountries: String,

        @ColumnInfo(name = "spokenLanguages")
        var spokenLanguages: String,

        // TODO: 19/04/17 Adding relation for genre ids
        // @ColumnInfo(name = "genre_ids")
        // Integer[] movie_genres;

        @ColumnInfo(name = "voteCount")
        var movieVoteCount: Int,

        @ColumnInfo(name = "runtime")
        var movieRuntime: Int,

        @ColumnInfo(name = "popularity")
        var moviePopularity: Float,

        @ColumnInfo(name = "voteAverage")
        var voteAverage: Float,

        @ColumnInfo(name = "isAdult")
        var isAdult: Boolean = false,

        @ColumnInfo(name = "hasVideo")
        var hasVideo: Boolean = false,

        @ColumnInfo(name = "revenue")
        var movieRevenue: Long = 0
)
