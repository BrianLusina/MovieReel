package com.moviereel.domain.exceptions

/**
 * @author lusinabrian on 26/04/18.
 * @Notes Wrapper around exceptions used to manage default errors
 */
class DefaultErrorBundle(var caughtException: Exception) : ErrorBundle{
    companion object {
        private const val DEFAULT_ERROR_MESSAGE = "Unknown Error"
    }

    override fun getErrorMessage(): String {
        return if (caughtException != null){
            caughtException.message.toString()
        } else {
            DEFAULT_ERROR_MESSAGE
        }
    }

    override fun getException(): Exception {
        return caughtException
    }
}