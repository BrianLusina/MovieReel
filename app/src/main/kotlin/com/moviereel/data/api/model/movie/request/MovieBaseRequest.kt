package com.moviereel.data.api.model.movie.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.api.model.BaseRequest

import io.reactivex.annotations.Nullable

/**
 * @author lusinabrian on 08/04/17
 * * every api endpoint call made to the movie endpoint will extend this class
 */

abstract class MovieBaseRequest : BaseRequest {

    @Expose
    @SerializedName("region")
    var region: String? = null

    constructor(page: Int, language: String, @Nullable region: String) : super(page, language) {
        this.region = region
    }

    constructor(language: String) : super(language)
}
