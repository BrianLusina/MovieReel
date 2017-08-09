package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.db.entities.BaseEntity

/**
 * @author lusinabrian
 * *
 * @Notes: Now playing movie model
 * *
 * * Example model we should expect to save
 * * "poster_path": "/y4MBh0EjBlMuOzv9axM4qJlmhzz.jpg",
 * * "adult": false,
 * * "overview": "The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quill's true parentage.",
 * * "releaseDate": "2017-04-24",
 * * "genre_ids": [ 35, 28, 12, 878 ],
 * * "id": 283995,
 * * "original_title": "Guardians of the Galaxy Vol. 2",
 * * "original_language": "en",
 * * "title": "Guardians of the Galaxy Vol. 2",
 * * "backdrop_path": "/aJn9XeesqsrSLKcHfHP4u5985hn.jpg",
 * * "popularity": 125.757946,
 * * "vote_count": 1437,
 * * "video": false,
 * *
 */
@Entity(tableName = "movie_now_playing")
data class MovieNPEntity(

        @PrimaryKey
        @Expose
        @SerializedName("id")
        var id: Long = 0,

        @Expose
        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String? = null,

        @ColumnInfo(name = "movieId")
        var movieId: Int = 0,

        @ColumnInfo(name = "movieImdbId")
        @Expose
        @SerializedName("movie_imdb_id")
        @Ignore
        var movieImdbId: String = "",

        @ColumnInfo(name = "movieTitle")
        var movieTitle: String = "",

        @ColumnInfo(name = "posterUrl")
        var moviePosterUrl: String = "",

        @ColumnInfo(name = "backdropUrl")
        var movieBackdropUrl: String = "",

        @Expose
        @SerializedName("release_date")
        @ColumnInfo(name = "releaseDate")
        var releaseDate: String = "",

        @ColumnInfo(name = "homepage")
        var movieHomepage: String = "",

        @ColumnInfo(name = "originalLang")
        var originalLang: String = "",

        @Expose
        @SerializedName("original_title")
        @ColumnInfo(name = "originalTitle")
        var originalTitle: String = "",

        @ColumnInfo(name = "movieStatus")
        var movieStatus: String = "",

        @ColumnInfo(name = "movieTagline")
        var movieTagline: String = "",

        @ColumnInfo(name = "movieGenres")
        var movieGenres: String = "",

        @ColumnInfo(name = "productionCompanies")
        var productionCompanies: String = "",

        @ColumnInfo(name = "productionCountries")
        var productionCountries: String = "",

        @ColumnInfo(name = "spokenLanguages")
        var spokenLanguages: String = "",

        @ColumnInfo(name = "runtime")
        var movieRuntime: Int = 0,

        @ColumnInfo(name = "revenue")
        var movieRevenue: Long = 0
) : BaseEntity(), Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<MovieNPEntity> = object : Parcelable.Creator<MovieNPEntity> {
            override fun createFromParcel(source: Parcel): MovieNPEntity = MovieNPEntity(source)
            override fun newArray(size: Int): Array<MovieNPEntity?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readLong(),
            source.readString(),
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readLong()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(id)
        dest.writeString(title)
        dest.writeInt(movieId)
        dest.writeString(movieImdbId)
        dest.writeString(movieTitle)
        dest.writeString(moviePosterUrl)
        dest.writeString(movieBackdropUrl)
        dest.writeString(releaseDate)
        dest.writeString(movieHomepage)
        dest.writeString(originalLang)
        dest.writeString(originalTitle)
        dest.writeString(movieStatus)
        dest.writeString(movieTagline)
        dest.writeString(movieGenres)
        dest.writeString(productionCompanies)
        dest.writeString(productionCountries)
        dest.writeString(spokenLanguages)
        dest.writeInt(movieRuntime)
        dest.writeLong(movieRevenue)
    }
}