package com.moviereel.utils

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.provider.Settings
import android.support.v4.content.ContextCompat

import com.moviereel.R

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

import cn.pedant.SweetAlert.SweetAlertDialog
import android.graphics.drawable.ColorDrawable



/**
 * @author lusinabrian on 28/03/17
 * * utility class for methods common in the overall application
 */

object CommonUtils {

    /**
     * Creates a sweet alert loading progress
     * This will simply build the sweet alert dialog progress bar that will be shown later
     * @param mContext the context to use in the creation of this SweetAlertDialog
     * *
     * @return [SweetAlertDialog.PROGRESS_TYPE]
     */
    @JvmStatic
    fun showSweetAlertLoadingProgress(mContext: Context): SweetAlertDialog {
        val sweetProgress = SweetAlertDialog(mContext, SweetAlertDialog.PROGRESS_TYPE)
        sweetProgress.progressHelper.barColor = ContextCompat.getColor(mContext, R.color.cadet_blue)
        sweetProgress.titleText = "Loading..."
        sweetProgress.setCancelable(true)
        return sweetProgress
    }

    @JvmStatic
    fun showProgressDialog(mContext: Context): ProgressDialog{
        val progressDialog = ProgressDialog(mContext)
        progressDialog.show()
        if (progressDialog.window != null) {
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        progressDialog.setContentView(R.layout.progress_dialog)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog

    }

    @SuppressLint("all")
    fun getDeviceId(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    val timeStamp: String
        get() = SimpleDateFormat(TIMESTAMP_FORMAT, Locale.UK).format(Date())
}
