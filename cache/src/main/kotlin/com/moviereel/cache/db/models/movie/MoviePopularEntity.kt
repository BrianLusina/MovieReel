package com.moviereel.cache.db.models.movie

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 15/05/17.
 * @Notes Popular Movie Model (POJO) that will be mapped to a row in the table movie_popular
 * * in the database
 */
@Entity(tableName = "movie_popular")
data class MoviePopularCacheEntity(
        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("id")
        var id: Long = 0
)