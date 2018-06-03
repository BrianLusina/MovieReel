@file:JvmName("NetworkUtils")
package com.moviereel.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Method to check network availability
 * Using ConnectivityManager to check for IsNetwork Connection
 */
fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
}
