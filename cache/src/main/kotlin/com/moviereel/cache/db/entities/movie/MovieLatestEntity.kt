package com.moviereel.data.db.entities.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.cache.db.entities.BaseEntity
import com.moviereel.domain.models.GenreModel
import com.moviereel.domain.models.ProductionCompany
import com.moviereel.domain.models.ProductionCountry
import com.moviereel.domain.models.SpokenLanguage

/**
 * @author lusinabrian on 15/05/17.
 * *
 * @Notes Data entry for the latest movie
 */
// @Entity(tableName = "movie_latest")
data class MovieLatestEntity(

        @Expose
        //@ColumnInfo(name = "belongs_to_collection")
        var belongsToCollection: String? = null,

        @Expose
        //@ColumnInfo(name = "budget")
        var budget: Int = 0,

        @Expose
        //@ColumnInfo(name = "genres")
        //@Ignore
        var genres: ArrayList<GenreModel>,

        @Expose
        @SerializedName("homepage")
        //@ColumnInfo(name = "homepage")
        var homepage: String,

        @Expose
        @SerializedName("imdb_id")
        //@ColumnInfo(name = "imdb_id")
        var imdbId: String,

        @Expose
        @SerializedName("production_companies")
        //@ColumnInfo(name = "production_companies")
        //@Ignore
        var productionCompanies: ArrayList<ProductionCompany>,

        @Expose
        @SerializedName("production_countries")
        //@ColumnInfo(name = "production_countries")
        //@Ignore
        var productionCountry: ArrayList<ProductionCountry>,

        @Expose
        @SerializedName("revenue")
        //@ColumnInfo(name = "revenue")
        var revenue: Int,

        @Expose
        @SerializedName("runtime")
        //@ColumnInfo(name = "runtime")
        var runtime: Int,

        @Expose
        @SerializedName("spoken_languages")
        //@ColumnInfo(name = "spoken_languages")
        //@Ignore
        var spokenLanguage: ArrayList<SpokenLanguage>,

        @Expose
        @SerializedName("status")
        //@ColumnInfo(name = "status")
        var status: String,

        @Expose
        @SerializedName("tagline")
        //@ColumnInfo(name = "tagline")
        var tagline: String
) : BaseEntity()
