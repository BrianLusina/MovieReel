package com.moviereel.data.api.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 31/03/17
 * * Base response
 */
sealed class BaseResultsResponse(
        @Expose
        @SerializedName("id")
        var id: Int? = 0,

        @Expose
        @SerializedName("adult")
        var isAdult: Boolean = false,

        @Expose
        @SerializedName("poster_path")
        var posterPath: String? = "",

        @Expose
        @SerializedName("overview")
        var overview: String? = "",

        @Expose
        @SerializedName("original_language")
        var originalLanguage: String? = "",

        @Expose
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,

        @Expose
        @SerializedName("video")
        var isVideo: Boolean = false,

        @Expose
        @SerializedName("vote_count")
        var voteCount: Int = 0,

        @Expose
        @SerializedName("vote_average")
        var voteAverage: Float = 0F,

        @Expose
        @SerializedName("popularity")
        var popularity: Float? = 0F,

        @Expose
        @SerializedName("genre_ids")
        var genreIds: List<Int>? = null
) {
    data class MovieResultsResponse(
            @Expose
            @SerializedName("release_date")
            var releaseDate: String,
            @Expose
            @SerializedName("title")
            var title: String? = null,

            @Expose
            @SerializedName("original_title")
            var originalTitle: String
    ) : BaseResultsResponse(), Parcelable {
        companion object {
            @JvmField val CREATOR: Parcelable.Creator<MovieResultsResponse> = object : Parcelable.Creator<MovieResultsResponse> {
                override fun createFromParcel(source: Parcel): MovieResultsResponse = MovieResultsResponse(source)
                override fun newArray(size: Int): Array<MovieResultsResponse?> = arrayOfNulls(size)
            }
        }

        constructor(source: Parcel) : this(
                source.readString(),
                source.readString(),
                source.readString()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) {
            dest.writeString(releaseDate)
            dest.writeString(title)
            dest.writeString(originalTitle)
        }
    }

    /***/
    data class MovieLatestResponse(
            @Expose
            @SerializedName("belongs_to_collection")
            private val belongsToCollection: String,

            @Expose
            @SerializedName("budget")
            private val budget: Int,

            @Expose
            @SerializedName("homepage")
            private val homepage: String,

            @Expose
            @SerializedName("genres")
            private val genres: Genres,

            @Expose
            @SerializedName("imdb_id")
            private val imdbId: String,

            @Expose
            @SerializedName("production_companies")
            private val productionCompanies: ArrayList<ProductionCompany>,

            @Expose
            @SerializedName("production_countries")
            private val productionCountries: ArrayList<ProductionCountry>,

            @Expose
            @SerializedName("revenue")
            private val revenue: Int,

            @Expose
            @SerializedName("runtime")
            private val runtime: Int,

            @Expose
            @SerializedName("spoken_languages")
            private val spokenLanguages: ArrayList<SpokenLanguage>,

            @Expose
            @SerializedName("status")
            private val status: String,

            @Expose
            @SerializedName("tagline")
            private val tagline: String
    ) : BaseResultsResponse()

    data class TvResultsResponse(

            @Expose
            @SerializedName("first_air_date")
            var firstAirDate: String,

            @Expose
            @SerializedName("origin_country")
            var originCountry: List<String>,

            @Expose
            @SerializedName("name")
            var name: String,

            @Expose
            @SerializedName("original_name")
            var originalName: String
    ) : BaseResultsResponse()
}
