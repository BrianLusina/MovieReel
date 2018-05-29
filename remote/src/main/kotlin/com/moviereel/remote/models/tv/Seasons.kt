package com.moviereel.remote.models.tv

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 10/04/17
 */

data class Seasons(

        @Expose
        @SerializedName("air_date")
        private val airDate: String? = null,

        @Expose
        @SerializedName("episode_count")
        private val episodeCount: Int = 0,

        @Expose
        @SerializedName("id")
        private val id: Int = 0,

        @Expose
        @SerializedName("poster_path")
        private val posterPath: String? = null,

        @Expose
        @SerializedName("season_number")
        private val seasonNumber: Int = 0
)
