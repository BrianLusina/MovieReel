package com.moviereel.remote.models.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.remote.models.BaseResponse
import com.moviereel.remote.models.DatesResponse

/**
 * @author lusinabrian on 01/04/17
 * @Notes Response object for upcoming movies. This will get upcoming movies for the next 1 month
 */
data class MovieUpcomingResponse(

        @Expose
        @SerializedName("dates")
        var datesResponse: DatesResponse? = null
) : BaseResponse()
