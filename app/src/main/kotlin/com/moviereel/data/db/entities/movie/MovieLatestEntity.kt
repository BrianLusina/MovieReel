package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author lusinabrian on 15/05/17.
 * *
 * @Notes Data entry for the latest movie
 */
@Entity(tableName = "movie_latest")
data class MovieLatestEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo
        var belongsToCollection: String,

        @ColumnInfo
        var budget: Int = 0,

        @ColumnInfo
        var homepage: String,

        @ColumnInfo
        var imdbId: String,

        // TODO: ADD RELATIONS TO OTHER TABLES, production companies, countries and spoken languages
//    @ColumnInfo
//    GenreResponse genres;
//    @ColumnInfo
//    List<ProductionCompany> productionCompanies;
//
//    @ColumnInfo
//    List<ProductionCountry> productionCountries;
//
//    @ColumnInfo
//    List<SpokenLanguage> spokenLanguages;
//
//    @ColumnInfo
//    List<Integer> genreIds;

        @ColumnInfo
        var revenue: Int,

        @ColumnInfo
        var runtime: Int,

        @ColumnInfo
        var status: String,

        @ColumnInfo
        var tagline: String,

        @ColumnInfo
        var adult: Boolean,

        @ColumnInfo
        var posterPath: String,

        @ColumnInfo
        var overview: String,

        @ColumnInfo
        var originalLanguage: String,

        @ColumnInfo
        var backdropPath: String,

        @ColumnInfo
        var video: Boolean,

        @ColumnInfo
        var voteCount: Int,
        @ColumnInfo
        var voteAverage: Float,
        @ColumnInfo
        var popularity: Float
)
