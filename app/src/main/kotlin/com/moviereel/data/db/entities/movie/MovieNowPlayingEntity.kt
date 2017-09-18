package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.Entity
import com.moviereel.data.db.entities.BaseEntity

/**
 * @author lusinabrian
 * *
 * @Notes: Now playing movie model
 */
@Entity(tableName = "movie_now_playing")
class MovieNowPlayingEntity : BaseEntity()