package com.moviereel.remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 10/04/17
 */

data class Networks(
        @Expose
        @SerializedName("id")
        private val id: Int = 0,

        @Expose
        @SerializedName("name")
        private val name: String? = null
)
