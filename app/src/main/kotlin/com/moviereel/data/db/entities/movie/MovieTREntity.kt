package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.db.entities.BaseEntity

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
data class MovieTREntity(

        // This is to allow using a data class, as data classes can not be created without 1 field in
        // their constructor
        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("id")
        @ColumnInfo(name = "id")
        override var id: Long = 0

) : BaseEntity(), Parcelable
