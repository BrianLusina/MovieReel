package com.moviereel.data.api.model.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.api.model.BaseResponse
import com.moviereel.data.db.entities.movie.MovieTopRatedEntity

/**
 * @author lusinabrian on 01/04/17
 * @Notes top rated response for movies
 */

data class MovieTopRatedResponse(
        @Expose
        @SerializedName("results")
        var results: ArrayList<MovieTopRatedEntity>
) : BaseResponse()
