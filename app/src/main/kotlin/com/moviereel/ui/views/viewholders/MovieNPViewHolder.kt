package com.moviereel.ui.views.viewholders

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.google.gson.Gson
import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.db.entities.movie.MovieNPEntity
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
    lateinit var movieResultsResponseList: List<MovieNPEntity>

//    init {
//        var progressBar = itemView.findViewById(R.id.itemMovieProgressbar) as ProgressBar
//        var movieImageView = itemView.findViewById(R.id.itemMovieImgView) as ImageView
//        var movieTitle = itemView.findViewById(R.id.itemMovieTitleTxtView) as TextView
//        var movieVoteAvg = itemView.findViewById(R.id.itemMovieVoteAvgTxtView) as TextView
//        var movieCategories = itemView.findViewById(R.id.itemMovieCategoriesTxtView) as TextView
//        var movieRuntime = itemView.findViewById(R.id.itemMovieRuntimeTxtView) as TextView
//    }

    constructor(itemView: View, movieResultsResponseList : ArrayList<MovieNPEntity>) : this(itemView){
        this.movieResultsResponseList = movieResultsResponseList
    }

    override fun clear() {

    }

    override fun onBind(position: Int) {
        val movieResultsResponse = movieResultsResponseList[position]
        movieTitle.text = movieResultsResponse.title
        movieVoteAvg.text = movieResultsResponse.voteAverage.toString()

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