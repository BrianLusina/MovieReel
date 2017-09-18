package com.moviereel.data.api.model.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.api.model.BaseResponse
import com.moviereel.data.db.entities.movie.MoviePopularEntity

/**
 * @author lusinabrian on 01/04/17
 * * Response we get when we request for a list of popular movies
 */

data class MoviePopularResponse(
        @Expose
        @SerializedName("results")
        var results: ArrayList<MoviePopularEntity>) : BaseResponse()
