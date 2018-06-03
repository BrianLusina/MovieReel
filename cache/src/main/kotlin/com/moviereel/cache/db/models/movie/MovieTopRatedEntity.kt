package com.moviereel.cache.db.models.movie

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 16/05/17.
 * @Notes Top rated POJO. Represents 1 row in the table movie_top_rated
 */

@Entity(tableName = "movie_top_rated")
data class MovieTopRatedCacheEntity(
        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("id")
        var id: Long = 0
)
