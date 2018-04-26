package com.moviereel.domain.exceptions

/**
 * @author lusinabrian on 26/04/18.
 * @Notes Interface that represents a wrapper around [Exception] to manage errors
 */
interface ErrorBundle {

    /**
     * Get exception
     * @return [Exception]
     */
    fun getException() : Exception

    /**
     * Get the error message
     * @return [String]
     */
    fun getErrorMessage() : String
}