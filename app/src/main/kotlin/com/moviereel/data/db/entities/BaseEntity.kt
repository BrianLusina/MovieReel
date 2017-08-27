package com.moviereel.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 09/08/17.
 * @Notes
 */
open class BaseEntity(
        @Expose
        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String = "",

        @Expose
        @SerializedName("adult")
        @ColumnInfo(name = "adult")
        var isAdult: Boolean = false,

        @Expose
        @SerializedName("poster_path")
        @ColumnInfo(name = "poster_path")
        var posterPath: String? = "",

        @Expose
        @SerializedName("overview")
        @ColumnInfo(name = "overview")
        var overview: String? = "",

        @Expose
        @SerializedName("original_language")
        @ColumnInfo(name = "original_lang")
        var originalLanguage: String? = "",

        @Expose
        @SerializedName("backdrop_path")
        @ColumnInfo(name = "backdrop_path")
        var backdropPath: String? = null,

        @Expose
        @SerializedName("video")
        @ColumnInfo(name = "video")
        var isVideo: Boolean = false,

        @Expose
        @SerializedName("hasVideo")
        @Ignore
        var hasVideo: Boolean = false,

        @Expose
        @SerializedName("vote_count")
        @ColumnInfo(name = "vote_count")
        var voteCount: Int = 0,

        @Expose
        @SerializedName("vote_average")
        @ColumnInfo(name = "vote_average")
        var voteAverage: Float = 0F,

        @Expose
        @SerializedName("popularity")
        @ColumnInfo(name = "popularity")
        var popularity: Float? = 0F,

        @Expose
        @SerializedName("genre_ids")
        @Ignore
        var genreIds: List<Int>? = null
)