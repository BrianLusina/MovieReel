package com.moviereel.ui.views.viewholders

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.gson.Gson
import com.moviereel.BuildConfig
import com.moviereel.R
import com.moviereel.data.api.model.movie.response.MovieResultsResponse
import com.moviereel.ui.base.BaseViewHolder

/**
 * @author lusinabrian on 10/06/17.
 * @Notes
 */
class MovieNPViewHolder(itemView: View) : BaseViewHolder(itemView){
    
    lateinit var progressBar: ProgressBar
    lateinit var movieImageView: ImageView
    lateinit var movieTitle: TextView
    lateinit var movieVoteAvg: TextView
    lateinit var movieCategories: TextView
    lateinit var movieRuntime: TextView
    lateinit var movieResultsResponseList: List<MovieResultsResponse>

    init {
        var progressBar = itemView.findViewById(R.id.item_movie_progressbar) as ProgressBar
        var movieImageView = itemView.findViewById(R.id.item_movie_imgView) as ImageView
        var movieTitle = itemView.findViewById(R.id.item_movie_title_txtView) as TextView
        var movieVoteAvg = itemView.findViewById(R.id.item_movie_voteAvg_txtView) as TextView
        var movieCategories = itemView.findViewById(R.id.item_movieCategories_txtView) as TextView
        var movieRuntime = itemView.findViewById(R.id.item_movieRuntime_txtView) as TextView
    }

    constructor(itemView: View, movieResultsResponseList : List<MovieResultsResponse>) : this(itemView){
        this.movieResultsResponseList = movieResultsResponseList
    }

    override fun clear() {

    }

    override fun onBind(position: Int) {
        val movieResultsResponse = movieResultsResponseList.get(position)
        movieTitle.setText(movieResultsResponse.getTitle())
        movieVoteAvg.setText(movieResultsResponse.getVoteAverage().toString())

        // glide images to image views
//        Glide.with(mContext)
//                .load(BuildConfig.POSTER_PATH + movieResultsResponse.getPosterPath())
//                .listener(object : RequestListener<String, GlideDrawable> {
//                    override fun onException(e: Exception, model: String, target: Target<GlideDrawable>, isFirstResource: Boolean): Boolean {
//                        return false
//                    }
//
//                    override fun onResourceReady(resource: GlideDrawable, model: String, target: Target<GlideDrawable>, isFromMemoryCache: Boolean, isFirstResource: Boolean): Boolean {
//                        progressBar.visibility = View.GONE
//                        return false
//                    }
//                })
//                .fitCenter()
//                .crossFade()
//                .into(movieImageView)
        // movieRuntime.setText(movieResultsResponse.get);
        // nowPlayingResponse.getResults()
        // movieRuntime.setText(nowPlayingResponse.get);

        // open movie details activity
        itemView.setOnClickListener {
            val gson = Gson()
            val openMovieIntent = Intent()
            openMovieIntent.putExtra("MovieObj", gson.toJson(movieResultsResponse))
            itemView.context.startActivity(openMovieIntent)
        }
    }
}