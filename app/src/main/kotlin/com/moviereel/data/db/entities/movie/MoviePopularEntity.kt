package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.Entity
import com.moviereel.data.db.entities.BaseEntity

/**
 * @author lusinabrian on 15/05/17.
 * @Notes Popular Movie Model (POJO) that will be mapped to a row in the table movie_popular
 * * in the database
 */
@Entity(tableName = "movie_popular")
class MoviePopularEntity : BaseEntity()