package com.moviereel.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * @author lusinabrian on 01/04/17
 * * Base response that are similar across all responses from api calls
 */

abstract class BaseResponse {

    @Expose
    @SerializedName("page")
    var page: Int = 0

    @Expose
    @SerializedName("total_pages")
    var totalPages: Int = 0

    @Expose
    @SerializedName("total_results")
    var totalResults: Int = 0
}
