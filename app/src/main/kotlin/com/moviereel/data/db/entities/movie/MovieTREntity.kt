package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author lusinabrian on 16/05/17.
 * *
 * @Notes Top rated POJO. Represents 1 row in the table movie_top_rated
 * *
 * * An example of what we expect:
 * *
 * * "poster_path": "/2gvbZMtV1Zsl7FedJa5ysbpBx2G.jpg",
 * * "adult": false,
 * * "overview": "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
 * * "release_date": "1995-10-19",
 * * "genre_ids": [35,18,10749],
 * * "id": 19404,
 * * "original_title": "दिलवाले दुल्हनिया ले जाएंगे",
 * * "original_language": "hi",
 * * "title": "Dilwale Dulhania Le Jayenge",
 * * "backdrop_path": "/nl79FQ8xWZkhL3rDr1v2RFFR6J0.jpg",
 * * "popularity": 2.879931,
 * * "vote_count": 183,
 * * "video": false,
 * * "vote_average": 8.8
 */

@Entity(tableName = "movie_top_rated")
class MovieTREntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo(name = "poster_path")
    var posterPath: String? = null

    @ColumnInfo(name = "overview")
    var overview: String? = null

    @ColumnInfo(name = "release_date")
    var releaseDate: String? = null

    @ColumnInfo(name = "original_title")
    var originalTitle: String? = null

    @ColumnInfo(name = "original_language")
    var originalLanguage: String? = null

    @ColumnInfo(name = "title")
    var title: String? = null

    @ColumnInfo(name = "backdrop_path")
    var backdropPath: String? = null

    @ColumnInfo(name = "popularity")
    var popularity: Long = 0

    @ColumnInfo(name = "vote_count")
    var voteCount: Int = 0

    @ColumnInfo(name = "video")
    private var video: Boolean = false

    @ColumnInfo(name = "vote_average")
    var voteAverage: Long = 0
}
