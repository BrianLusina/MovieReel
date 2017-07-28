package com.moviereel.data.prefs

/**
 * @author lusinabrian on 28/03/17
 * * This interface will allow interaction with the [android.content.SharedPreferences] API
 * * This will handle all data relating to shared preferences such as settings configuration and storing user
 * * data. This will be delegated that task by [com.moviereel.data.DataManager]
 */

interface PreferencesHelper {

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
    fun setFirstStart(setFirstStart: Boolean) : Unit

}
