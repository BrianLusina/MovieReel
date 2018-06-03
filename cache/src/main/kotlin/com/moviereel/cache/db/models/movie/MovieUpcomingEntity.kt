package com.moviereel.cache.db.models.movie


import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 16/05/17.
 * @Notes An upcoming Movie model. Used when storing upcoming movie items in the database
 */

@Entity(tableName = "movie_upcoming")
data class MovieUpcomingCacheEntity(
        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("id")
        var id: Long = 0
)