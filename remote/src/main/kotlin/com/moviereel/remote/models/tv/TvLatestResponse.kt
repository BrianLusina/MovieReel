package com.moviereel.remote.models.tv

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.remote.models.Networks
import com.moviereel.data.db.entities.ProductionCompany
import com.moviereel.data.db.entities.GenreEntity

/**
 * @author lusinabrian on 10/04/17
 * * This is the response we get back when we do a fetch for the latest tv show
 */

data class TvLatestResponse(

        @Expose
        @SerializedName("backdrop_path")
        var backdropPath: String,

        //    @Expose
        //    @SerializedName("created_by")
        //    private List<> createdBy;

        @Expose
        @SerializedName("episode_run_time")
        var episodeRunTime: List<Int>,

        @Expose
        @SerializedName("first_air_date")
        var firstAirDate: String,

        @Expose
        @SerializedName("genres")
        var genres: List<GenreEntity>,

        @Expose
        @SerializedName("homepage")
        var homepage: String,

        @Expose
        @SerializedName("id")
        var id: Int = 0,

        @Expose
        @SerializedName("in_production")
        var isInProduction: Boolean = false,

        @Expose
        @SerializedName("languages")
        var languages: List<String>,

        @Expose
        @SerializedName("last_air_date")
        var lastAirDate: String,

        @Expose
        @SerializedName("name")
        var name: String,

        @Expose
        @SerializedName("networks")
        var networks: List<Networks>,

        @Expose
        @SerializedName("number_of_episodes")
        var numberOfEpisodes: Int = 0,

        @Expose
        @SerializedName("number_of_seasons")
        var numberOfSeasons: Int = 0,

        @Expose
        @SerializedName("origin_country")
        var originCountry: List<String>,

        @Expose
        @SerializedName("original_language")
        var originalLanguage: String,

        @Expose
        @SerializedName("original_name")
        var originalName: String,

        @Expose
        @SerializedName("overview")
        var overview: String,

        @Expose
        @SerializedName("popularity")
        var popularity: Int = 0,

        @Expose
        @SerializedName("poster_path")
        var posterPath: String,

        @Expose
        @SerializedName("production_companies")
        var productionCompanies: List<ProductionCompany>,

        @Expose
        @SerializedName("seasons")
        var seasons: List<Seasons>,

        @Expose
        @SerializedName("status")
        var status: String,

        @Expose
        @SerializedName("type")
        var type: String,

        @Expose
        @SerializedName("vote_average")
        var voteAverage: Int = 0,

        @Expose
        @SerializedName("vote_count")
        var voteCount: Int = 0

)
