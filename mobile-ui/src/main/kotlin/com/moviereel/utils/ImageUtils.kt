package com.moviereel.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.moviereel.BuildConfig
import java.lang.Exception

/**
 * @author lusinabrian on 11/09/17.
 * @Notes Image utilities
 */

/**
 * loads an image from a url onto an image view
 * @param context context to use this
 * @param url url to load from
 * @param progressBar progress bar if any
 * */
fun ImageView.loadImageFromUrl(context: Context, url: String, progressBar : View? = null){
    Glide.with(context)
            .load(url)
            .listener(object : RequestListener<String, GlideDrawable> {
                override fun onException(e: Exception?, model: String?, target: Target<GlideDrawable>?,
                                         isFirstResource: Boolean): Boolean {
                    return false
                }

                override fun onResourceReady(resource: GlideDrawable?, model: String?,
                                             target: Target<GlideDrawable>?,
                                             isFromMemoryCache: Boolean, isFirstResource: Boolean)
                        : Boolean {
                    if(progressBar != null){
                     progressBar.visibility = View.GONE
                    }
                    return false
                }
            })
            .crossFade()
            .thumbnail(1F)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
}
