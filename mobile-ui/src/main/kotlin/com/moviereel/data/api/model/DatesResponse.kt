package com.moviereel.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.Date

/**
 * @author lusinabrian on 30/03/17
 */

data class DatesResponse(
    @Expose
    @SerializedName("maximum")
    var maximum: Date,

    @Expose
    @SerializedName("minimum")
    var minimum: Date
)
