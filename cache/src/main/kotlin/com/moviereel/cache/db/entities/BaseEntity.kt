package com.moviereel.cache.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * @author lusinabrian on 09/08/17.
 * @Notes Base entity for objects
 */
@Parcelize
open class BaseEntity(
        @Expose
        @SerializedName("vote_count")
        @ColumnInfo(name = "vote_count")
        open var voteCount: Int = 0,

        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("id")
        open var id: Long = 0,

        @Expose
        @SerializedName("video")
        @ColumnInfo(name = "video")
        open var video: Boolean = false,

        @Expose
        @SerializedName("vote_average")
        @ColumnInfo(name = "vote_average")
        open var voteAverage: Float = 0F,

        @Expose
        @SerializedName("title")
        @ColumnInfo(name = "title")
        open var title: String = "",

        @Expose
        @SerializedName("popularity")
        @ColumnInfo(name = "popularity")
        open var popularity: Float = 0F,

        @Expose
        @SerializedName("poster_path")
        @ColumnInfo(name = "poster_path")
        open var posterPath: String? = "",

        @Expose
        @SerializedName("original_language")
        @ColumnInfo(name = "original_lang")
        open var originalLanguage: String? = "",

        @Expose
        @SerializedName("original_title")
        @ColumnInfo(name = "original_title")
        open var originalTitle: String = "",

        @Expose
        @SerializedName("genre_ids")
        @ColumnInfo(name = "genre_ids")
        open var genreIds: List<Int> = listOf(),

        @Expose
        @SerializedName("backdrop_path")
        @ColumnInfo(name = "backdrop_path")
        open var backdropPath: String? = null,

        @Expose
        @SerializedName("adult")
        @ColumnInfo(name = "adult")
        open var isAdult: Boolean = false,

        @Expose
        @SerializedName("overview")
        @ColumnInfo(name = "overview")
        open var overview: String? = "",

        @Expose
        @SerializedName("release_date")
        @ColumnInfo(name = "release_date")
        open var releaseDate: String = ""
) : Parcelable