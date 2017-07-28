package com.moviereel.data.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.di.ApiInfo

import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 28/03/17
 * * Handles headers passed in GET request when accessing the API
 */

@Singleton
class ApiHeader @Inject
constructor(val protectedApiHeader: ApiHeader.ProtectedApiHeader) {

    /**
     * this class should not be instantiated and will be used when fetching data that only needs
     * an api key for fetching any data */
    class ProtectedApiHeader(@param:ApiInfo @Expose
                             @SerializedName("api_key")
                             var apiKey: String?)

}
