package com.moviereel.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 31/03/17
 */

data class Genres(

        @Expose
        @SerializedName("id")
        private val id: Int = 0,

        @Expose
        @SerializedName("name")
        private val name: String? = null
)
