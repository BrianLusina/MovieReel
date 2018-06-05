package com.moviereel.data.source

/**
 * @author lusinabrian on 05/06/18.
 * @Notes Responsible for defining methods related to cache data related to the application
 */
interface DataCache {
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