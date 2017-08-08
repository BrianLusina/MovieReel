package com.moviereel.data.db.entities.movie


import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author lusinabrian on 16/05/17.
 * *
 * @Notes An upcoming Movie model. Used when storing upcoming movie items in the database
 * *
 * * An example of data we will be storing
 * * {
 * *  "poster_path": "/qwoGfcg6YUS55nUweKGujHE54Wy.jpg",
 * *  "adult": false,
 * *  "overview": "Captain Jack Sparrow is pursued by an old rival, Captain Salazar, who along with his crew of ghost pirates has escaped from the Devil's Triangle, and is determined to kill every pirate at sea. Jack seeks the Trident of Poseidon, a powerful artifact that grants its possessor total control over the seas, in order to defeat Salazar.",
 * *  "release_date": "2017-05-24",
 * *  "genre_ids": [ 28, 12, 35, 14 ],
 * *  "id": 166426,
 * *  "original_title": "Pirates of the Caribbean: Dead Men Tell No Tales",
 * *  "original_language": "en",
 * *  "title": "Pirates of the Caribbean: Dead Men Tell No Tales",
 * *  "backdrop_path": "/3DVKG54lqYbdh8RNylXeCf4MBPw.jpg",
 * *  "popularity": 19.733165,
 * *  "vote_count": 49,
 * *  "video": false,
 * *  "vote_average": 0
 * *  }
 */

@Entity(tableName = "movie_upcoming")
data class MovieUEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,

        @ColumnInfo(name = "poster_path")
        val posterPath: String,

        @ColumnInfo(name = "overview")
        val overview: String,

        @ColumnInfo(name = "release_date")
        val releaseDate: String,

        @ColumnInfo(name = "original_title")
        val originalTitle: String,

        @ColumnInfo(name = "original_language")
        val originalLanguage: String,

        @ColumnInfo(name = "title")
        val title: String,

        @ColumnInfo(name = "backdrop_path")
        val backdropPath: String,

        @ColumnInfo(name = "popularity")
        val popularity: Long,

        @ColumnInfo(name = "vote_count")
        val voteCount: Int,

        @ColumnInfo(name = "video")
        val video: Boolean,

        @ColumnInfo(name = "vote_average")
        val voteAverage: Long
)
