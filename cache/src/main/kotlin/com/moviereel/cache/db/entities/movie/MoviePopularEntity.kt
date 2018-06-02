package com.moviereel.cache.db.entities.movie

import android.arch.persistence.room.Entity
import com.moviereel.domain.models.BaseEntity

/**
 * @author lusinabrian on 15/05/17.
 * @Notes Popular Movie Model (POJO) that will be mapped to a row in the table movie_popular
 * * in the database
 */
@Entity(tableName = "movie_popular")
class MoviePopularCacheEntity