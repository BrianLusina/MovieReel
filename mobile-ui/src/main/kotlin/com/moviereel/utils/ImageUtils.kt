package com.moviereel.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/**
 * loads an image from a url onto an image view
 * @param context context to use this
 * @param url url to load from
 * @param progressBar progress bar if any
 * */
fun ImageView.loadImageFromUrl(context: Context, url: String, progressBar : View? = null){
    Glide.with(context)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    if(progressBar != null){
                        progressBar.visibility = View.GONE
                    }
                    return false
                }

                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    return false
                }
            })
            .thumbnail(1F)
            .into(this)
}
