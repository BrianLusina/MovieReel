package com.moviereel.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 31/03/17
 * * Base request that all requests will inherit from
 */

abstract class BaseRequest {

    @Expose
    @SerializedName("page")
    var page: Int = 0

    @Expose
    @SerializedName("language")
    var language: String? = null

    constructor(page: Int, language: String) {
        this.page = page
        this.language = language
    }

    constructor(language: String) {
        this.language = language
    }
}
