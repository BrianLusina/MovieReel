package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 15/05/17.
 * @Notes Popular Movie Model (POJO) that will be mapped to a row in the table movie_popular
 * * in the database
 */
@Entity(tableName = "movie_popular")
data class MoviePEntity(
        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("id")
        var id: Long,

        @Expose
        @SerializedName("vote_count")
        @ColumnInfo(name = "vote_count")
        var voteCount: Int = 0,

        @Expose
        @SerializedName("video")
        @ColumnInfo(name = "video")
        var video: Boolean,

        @Expose
        @SerializedName("vote_average")
        @ColumnInfo(name = "vote_average")
        var voteAverage: Float,

        @Expose
        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String,

        @Expose
        @SerializedName("popularity")
        @ColumnInfo(name = "popularity")
        var popularity: Float,

        @Expose
        @SerializedName("poster_path")
        @ColumnInfo(name = "poster_path")
        var posterPath: String,

        @Expose
        @SerializedName("original_language")
        @ColumnInfo(name = "original_language")
        var originalLanguage: String,

        @Expose
        @SerializedName("original_title")
        @ColumnInfo(name = "original_title")
        var originalTitle: String,

        @Expose
        @SerializedName("genre_ids")
        @ColumnInfo(name = "genre_ids")
        var genreIds: List<Int>,

        @Expose
        @SerializedName("backdrop_path")
        @ColumnInfo(name = "backdrop_path")
        var backdropPath: String,

        @Expose
        @SerializedName("adult")
        @ColumnInfo(name = "adult")
        var adult: Boolean = false,

        @Expose
        @SerializedName("overview")
        @ColumnInfo(name = "overview")
        var overview: String,

        @Expose
        @SerializedName("release_date")
        @ColumnInfo(name = "release_date")
        var releaseDate: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readLong(),
            source.readInt(),
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
        writeLong(id)
        writeInt(voteCount)
        writeInt((if (video) 1 else 0))
        writeFloat(voteAverage)
        writeString(title)
        writeFloat(popularity)
        writeString(posterPath)
        writeString(originalLanguage)
        writeString(originalTitle)
        writeList(genreIds)
        writeString(backdropPath)
        writeInt((if (adult) 1 else 0))
        writeString(overview)
        writeString(releaseDate)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MoviePEntity> = object : Parcelable.Creator<MoviePEntity> {
            override fun createFromParcel(source: Parcel): MoviePEntity = MoviePEntity(source)
            override fun newArray(size: Int): Array<MoviePEntity?> = arrayOfNulls(size)
        }
    }
}
