package com.moviereel.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

import com.moviereel.ui.main.MainActivity
import com.moviereel.utils.NetworkUtils

/**
 * @author lusinabrian on 19/04/17.
 */

class ConnChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.net.conn.CONNECTIVITY_CHANGE") {
            // Explicitly specify that which service class will handle the intent.

            val openMainActivity = Intent(context, MainActivity::class.java)

            // if connected to KIO WIFI, open the connected check as a new task
            // this will allow to display a simple dialog
            if (NetworkUtils.isNetworkAvailable(context)) {
                openMainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(openMainActivity)
            }
        }
    }
}
