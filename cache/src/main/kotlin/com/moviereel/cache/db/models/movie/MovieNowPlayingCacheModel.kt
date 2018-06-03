package com.moviereel.cache.db.models.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian
 * @Notes: Now playing movie model
 */
@Entity(tableName = "movie_now_playing")
data class MovieNowPlayingCacheModel(
        @Expose
        @SerializedName("vote_count")
        @ColumnInfo(name = "vote_count")
        var voteCount: Int = 0,

        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("id")
        var id: Long = 0,

        @Expose
        @SerializedName("video")
        @ColumnInfo(name = "video")
        var video: Boolean = false,

        @Expose
        @SerializedName("vote_average")
        @ColumnInfo(name = "vote_average")
        var voteAverage: Float = 0F,

        @Expose
        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String = "",

        @Expose
        @SerializedName("popularity")
        @ColumnInfo(name = "popularity")
        var popularity: Float = 0F,

        @Expose
        @SerializedName("poster_path")
        @ColumnInfo(name = "poster_path")
        var posterPath: String = "",

        @Expose
        @SerializedName("original_language")
        @ColumnInfo(name = "original_lang")
        var originalLanguage: String = "",

        @Expose
        @SerializedName("original_title")
        @ColumnInfo(name = "original_title")
        var originalTitle: String = "",

        @Expose
        @SerializedName("genre_ids")
        @ColumnInfo(name = "genre_ids")
        var genreIds: List<Int> = listOf(),

        @Expose
        @SerializedName("backdrop_path")
        @ColumnInfo(name = "backdrop_path")
        var backdropPath: String = "",

        @Expose
        @SerializedName("adult")
        @ColumnInfo(name = "adult")
        var isAdult: Boolean = false,

        @Expose
        @SerializedName("overview")
        @ColumnInfo(name = "overview")
        var overview: String = "",

        @Expose
        @SerializedName("release_date")
        @ColumnInfo(name = "release_date")
        var releaseDate: String = ""
)