package com.moviereel.data.api.model.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.api.model.BaseResponse
import com.moviereel.data.api.model.DatesResponse
import com.moviereel.data.db.entities.movie.MovieNowPlayingEntity

/**
 * @author lusinabrian on 29/03/17
 * response we get when interacting with the now playing response
 * */
data class MovieNowPlayingResponse(
        @Expose
        @SerializedName("dates")
        val dates: DatesResponse,

        @Expose
        @SerializedName("results")
        val results: ArrayList<MovieNowPlayingEntity>
) : BaseResponse()