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
    {
        "vote_count": 2085,
        "id": 315635,
        "video": false,
        "vote_average": 7.4,
        "title": "Spider-Man: Homecoming",
        "popularity": 94.407524,
        "poster_path": "/c24sv2weTHPsmDa7jEMN0m2P3RT.jpg",
        "original_language": "en",
        "original_title": "Spider-Man: Homecoming",
        "genre_ids": [ 28, 12, 878 ],
        "backdrop_path": "/vc8bCGjdVp0UbMNLzHnHSLRbBWQ.jpg",
        "adult": false,
        "overview": "Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.",
        "release_date": "2017-07-05"
    }
 */
@Entity(tableName = "movie_now_playing")
data class MovieNPEntity(

        @PrimaryKey
        @Expose
        @SerializedName("id")
        @ColumnInfo(name = "id")
        var movieId: Long = 0,

        @Expose
        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String = "",

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
        dest.writeString(title)
        dest.writeLong(movieId)
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