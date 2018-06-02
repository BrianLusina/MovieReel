package com.moviereel.cache.db.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 08/04/17
 */
@Entity(tableName = "genre_ids")
data class GenreCacheEntity(

        @PrimaryKey(autoGenerate = false)
        @Expose
        @ColumnInfo(name = "genreId")
        @SerializedName("id")
        val id : Long,

        @Expose
        @ColumnInfo(name = "genreName")
        @SerializedName("name")
        val genreName : String
)
