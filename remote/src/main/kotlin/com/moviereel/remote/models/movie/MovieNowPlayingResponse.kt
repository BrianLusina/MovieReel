package com.moviereel.remote.models.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 29/03/17
 * response we get when interacting with the now playing response
 * */
data class MovieNowPlayingResponse(
        @Expose
        @SerializedName("id")
        var id: Long,

        @Expose
        @SerializedName("vote_count")
        val voteCount: Int,

        @Expose
        @SerializedName("video")
        var video: Boolean,

        @Expose
        @SerializedName("vote_average")
        var voteAverage: Float,

        @Expose
        @SerializedName("title")
        var title: String,

        @Expose
        @SerializedName("popularity")
        var popularity: Float,

        @Expose
        @SerializedName("poster_path")
        var posterPath: String,

        @Expose
        @SerializedName("original_language")
        var originalLang: String,

        @Expose
        @SerializedName("original_title")
        var originalTitle: String,

        @Expose
        @SerializedName("genre_ids")
        var genreIds: ArrayList<Int>,

        @Expose
        @SerializedName("backdrop_path")
        var backdropPath: String,

        @Expose
        @SerializedName("adult")
        var adult: Boolean,

        @Expose
        @SerializedName("overview")
        var overview: String,

        @Expose
        @SerializedName("release_date")
        var releaseDate: String
)