package com.moviereel.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.db.entities.GenreEntity

/**
 * @author lusinabrian on 31/03/17
 * * Base response
 */
sealed class BaseResultsResponse {
    /***/
    data class MovieLatestResponse(
            @Expose
            @SerializedName("belongs_to_collection")
            private val belongsToCollection: String,

            @Expose
            @SerializedName("budget")
            private val budget: Int,

            @Expose
            @SerializedName("homepage")
            private val homepage: String,

            @Expose
            @SerializedName("genres")
            private val genreResponse: GenreEntity,

            @Expose
            @SerializedName("imdb_id")
            private val imdbId: String,

            @Expose
            @SerializedName("production_companies")
            private val productionCompanies: ArrayList<ProductionCompany>,

            @Expose
            @SerializedName("production_countries")
            private val productionCountries: ArrayList<ProductionCountry>,

            @Expose
            @SerializedName("revenue")
            private val revenue: Int,

            @Expose
            @SerializedName("runtime")
            private val runtime: Int,

            @Expose
            @SerializedName("spoken_languages")
            private val spokenLanguages: ArrayList<SpokenLanguage>,

            @Expose
            @SerializedName("status")
            private val status: String,

            @Expose
            @SerializedName("tagline")
            private val tagline: String
    ) : BaseResultsResponse()

    data class TvResultsResponse(

            @Expose
            @SerializedName("first_air_date")
            var firstAirDate: String,

            @Expose
            @SerializedName("origin_country")
            var originCountry: List<String>,

            @Expose
            @SerializedName("name")
            var name: String,

            @Expose
            @SerializedName("original_name")
            var originalName: String
    ) : BaseResultsResponse()
}
