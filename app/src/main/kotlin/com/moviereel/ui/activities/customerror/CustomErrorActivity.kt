package com.moviereel.ui.activities.customerror

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.moviereel.R


/**
 * MovieReel-app
 * com.moviereel.ui.activities.customerror
 * Created by lusinabrian on 15/03/17.
 * Description: Custom error screen for display what the error was to the user. This activity should never
 * be accessed however, in dire situations where the application does fail, this should be the display
 * and not an ANR screen
 */

class CustomErrorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_error)
    }

}
