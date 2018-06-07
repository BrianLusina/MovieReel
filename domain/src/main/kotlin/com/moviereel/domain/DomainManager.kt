package com.moviereel.domain

/**
 * @author lusinabrian on 05/06/18.
 * @Notes Domain manager is used to access data from the data layer that is not related to fetching
 * from an API or from a DB. This could be data from a file or data from a shared preference.
 * Mostly, the latter.
 */
interface DomainManager {

    /**
     * checks and sees if this application has been started for the first time
     * Returns True if this is the first start, False otherwise
     * @return [Boolean]
     */
    fun getFirstStart() : Boolean

    /**
     * Once the application has started for the first time, this will set the value to false
     * thus the app will start the splash screen activity when [.getFirstStart] is called
     * @param setFirstStart sets the value for the first start
     * *
     */
    fun setFirstStart(setFirstStart: Boolean)

}