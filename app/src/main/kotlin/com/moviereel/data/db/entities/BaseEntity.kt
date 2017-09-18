package com.moviereel.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 09/08/17.
 * @Notes Base entity for objects
 */
open class BaseEntity(
        @Expose
        @SerializedName("vote_count")
        @ColumnInfo(name = "vote_count")
        open var voteCount: Int = 0,

        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("id")
        @ColumnInfo(name = "id")
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
        open var backdropPath: String = "",

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
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readLong(),
            1 == source.readInt(),
            source.readFloat(),
            source.readString(),
            source.readFloat(),
            source.readString(),
            source.readString(),
            source.readString(),
            ArrayList<Int>().apply { source.readList(this, Int::class.java.classLoader) },
            source.readString(),
            1 == source.readInt(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(voteCount)
        writeLong(id)
        writeInt((if (video) 1 else 0))
        writeFloat(voteAverage)
        writeString(title)
        writeFloat(popularity)
        writeString(posterPath)
        writeString(originalLanguage)
        writeString(originalTitle)
        writeList(genreIds)
        writeString(backdropPath)
        writeInt((if (isAdult) 1 else 0))
        writeString(overview)
        writeString(releaseDate)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<BaseEntity> = object : Parcelable.Creator<BaseEntity> {
            override fun createFromParcel(source: Parcel): BaseEntity = BaseEntity(source)
            override fun newArray(size: Int): Array<BaseEntity?> = arrayOfNulls(size)
        }
    }
}