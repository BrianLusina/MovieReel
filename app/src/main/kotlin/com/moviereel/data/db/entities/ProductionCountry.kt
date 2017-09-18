package com.moviereel.data.db.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 31/03/17
 */

data class ProductionCountry(
        @Expose @SerializedName("name")
        var name: String,

        @Expose @SerializedName("id")
        var id: Int)
