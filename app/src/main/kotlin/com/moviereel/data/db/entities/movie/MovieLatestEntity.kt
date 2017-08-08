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
//    private Genres genres;
//    @ColumnInfo
//    private List<ProductionCompany> productionCompanies;
//
//    @ColumnInfo
//    private List<ProductionCountry> productionCountries;
//
//    @ColumnInfo
//    private List<SpokenLanguage> spokenLanguages;
//
//    @ColumnInfo
//    private List<Integer> genreIds;

        @ColumnInfo
        var revenue: Int,

        @ColumnInfo
        var runtime: Int,

        @ColumnInfo
        var status: String,

        @ColumnInfo
        var tagline: String,

        @ColumnInfo
        private var adult: Boolean,

        @ColumnInfo
        var posterPath: String,

        @ColumnInfo
        var overview: String,

        @ColumnInfo
        var originalLanguage: String,

        @ColumnInfo
        var backdropPath: String,

        @ColumnInfo
        private var video: Boolean,

        @ColumnInfo
        var voteCount: Int,
        @ColumnInfo
        var voteAverage: Float,
        @ColumnInfo
        var popularity: Float
)
