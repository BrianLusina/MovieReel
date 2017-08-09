package com.moviereel.data.api.model.movie.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.api.model.BaseResponse
import com.moviereel.data.db.entities.movie.MovieNPEntity

/**
 * @author lusinabrian on 29/03/17
 * * response we get when interacting with the now playing response
 * *
 */

class MovieNowPlayingResponse : BaseResponse() {
    companion object {
        @Expose
        @SerializedName("results")
        @JvmField
        val results = ArrayList<MovieNPEntity>()

    }
}
