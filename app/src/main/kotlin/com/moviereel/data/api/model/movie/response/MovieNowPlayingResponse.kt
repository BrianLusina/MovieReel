package com.moviereel.data.api.model.movie.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.db.entities.movie.MovieNPEntity

/**
 * @author lusinabrian on 29/03/17
 * * response we get when interacting with the now playing response
 * *
 */

data class MovieNowPlayingResponse(

        @Expose
        @SerializedName("dates")
        var datesResponse: DatesResponse,

        @Expose
        @SerializedName("results")
        var results: ArrayList<MovieNPEntity>

) : MovieBaseResponse()
