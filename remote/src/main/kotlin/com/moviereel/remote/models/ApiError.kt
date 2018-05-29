package com.moviereel.remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author lusinabrian on 28/03/17
 * * Error class for modeling API errors that may be encountered by the application during fetching of data
 */

class ApiError(var errorCode: Int, @Expose
@SerializedName("status_code")
var statusCode: String?, @Expose
               @SerializedName("message")
               var message: String?) {

    override fun equals(obj: Any?): Boolean {
        if (this === obj)
            return true
        if (obj == null || javaClass != obj.javaClass)
            return false

        val apiError = obj as ApiError?

        if (errorCode != apiError!!.errorCode)
            return false

        if (if (statusCode != null) statusCode != apiError.statusCode else apiError.statusCode != null)
            return false

        return if (message != null) message == apiError.message else apiError.message == null
    }

    override fun hashCode(): Int {
        var result = errorCode
        result = 31 * result + if (statusCode != null) statusCode!!.hashCode() else 0
        result = 31 * result + if (message != null) message!!.hashCode() else 0

        return result
    }

}
