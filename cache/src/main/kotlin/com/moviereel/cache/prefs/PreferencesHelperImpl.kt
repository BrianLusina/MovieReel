package com.moviereel.cache.prefs

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 28/03/17
 * * Implementation of [PreferencesHelper] whose responsibility is to ensure that the application prefs
 * * are handled accordingly. This is a singleton thus there will be only one reference to it.
 */

@Singleton
class PreferencesHelperImpl
@Inject
constructor(context: Context) : PreferencesHelper {

    companion object {
        private const val MOVIE_PREFS_FILE_NAME = "moviereel_prefs_file"
        private const val PREF_KEY_FIRST_START = "PREF_KEY_FIRST_START"
        private const val PREF_KEY_LAST_CACHE = "PREF_KEY_LAST_CACHE"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(MOVIE_PREFS_FILE_NAME, Context.MODE_PRIVATE)

    /**
     * checks and sees if this application has been started for the first time
     * Returns True if this is the first start, False otherwise

     * @return [Boolean]
     */
    override fun getFirstStart(): Boolean {
        return sharedPreferences.getBoolean(PREF_KEY_FIRST_START, true)
    }

    /**
     * Once the application has started for the first time, this will set the value to false
     * thus the app will start the splash screen activity when [.getFirstStart] is called

     * @param setFirstStart the value to set for the first start
     */
    override fun setFirstStart(setFirstStart: Boolean) {
        sharedPreferences.edit().putBoolean(PREF_KEY_FIRST_START, setFirstStart).apply()
    }

    override fun setLastCache(lastCache: Long) {
        sharedPreferences.edit().putLong(PREF_KEY_LAST_CACHE, lastCache).apply()
    }

    override fun getLastCache() = sharedPreferences.getLong(PREF_KEY_LAST_CACHE, 0)
}
