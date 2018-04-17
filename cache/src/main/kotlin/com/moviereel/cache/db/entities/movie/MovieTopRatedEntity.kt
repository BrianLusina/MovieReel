package com.moviereel.data.db.entities.movie

import android.arch.persistence.room.Entity
import com.moviereel.domain.models.BaseEntity

/**
 * @author lusinabrian on 16/05/17.
 * @Notes Top rated POJO. Represents 1 row in the table movie_top_rated
 */

@Entity(tableName = "movie_top_rated")
class MovieTopRatedEntity : BaseEntity()
