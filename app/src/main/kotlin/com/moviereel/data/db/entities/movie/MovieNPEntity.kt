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
        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("id")
        override var id: Long

) : BaseEntity(), Parcelable