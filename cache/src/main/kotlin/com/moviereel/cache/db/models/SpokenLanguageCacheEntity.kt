package com.moviereel.cache.db.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 31/03/17
 * * Model for spoken language
 */

class SpokenLanguageCacheEntity(

        @Expose
        @SerializedName("iso_639_1")
        private val isoCode: String,

        @Expose
        @SerializedName("name")
        private val name: String

)
