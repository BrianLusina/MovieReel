package com.moviereel.ui.movie.nowplaying

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.moviereel.BuildConfig
import com.moviereel.R

import com.moviereel.ui.movie.MovieDetailsActivity
import com.moviereel.ui.base.BaseViewHolder

import javax.inject.Inject
import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.db.entities.movie.MovieNPEntity
import kotlinx.android.synthetic.main.item_movie_layout.view.*

/**
 * @author lusinabrian on 01/06/17.
 * *
 * @Notes
 */

class MovieNPAdapter
@Inject
constructor(
        val movieResultsResponseList: ArrayList<MovieNPEntity>) : RecyclerView.Adapter<BaseViewHolder>() {

    lateinit var mCallback: Callback

    fun setCallback(callback: Callback) {
        mCallback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            VIEW_TYPE_NORMAL -> return ViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_movie_layout, parent, false))
            VIEW_TYPE_EMPTY ->
                return EmptyViewHolder(
                        LayoutInflater.from(parent.context).inflate(R.layout.item_empty_view, parent, false))
            else -> return EmptyViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_empty_view, parent, false))
        }
    }

    override fun onBindViewHolder(baseViewHolder: BaseViewHolder, i: Int) {
        baseViewHolder.onBind(i)
    }

    override fun getItemViewType(position: Int): Int {
        if (movieResultsResponseList.size > 0) {
            return VIEW_TYPE_NORMAL
        } else {
            return VIEW_TYPE_EMPTY
        }

    }

    override fun getItemCount(): Int {
        if (movieResultsResponseList.size > 0) {
            return movieResultsResponseList.size
        } else {
            return 1
        }
    }

    /**
     * Add Movie now playing responses to list
     */
    fun addItems(movieResultsResponses: List<MovieNPEntity>) {
        movieResultsResponseList.addAll(movieResultsResponses)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder(itemView) {

        override fun clear() {}

        override fun onBind(position: Int) {
            val movieResultsResponse = movieResultsResponseList[position]

            with(itemView) {
                itemMovieTitleTxtView.text = movieResultsResponse.title
                itemMovieVoteAvgTxtView.text = movieResultsResponse.voteAverage.toString()
                // itemMovieCategoriesTxtView
                // itemMovieRuntimeTxtView
                // glide images to image views
                Glide.with(context)
                        .load(BuildConfig.POSTER_PATH + movieResultsResponse.posterPath)
                        .listener(object : RequestListener<String, GlideDrawable> {
                            override fun onException(e: Exception, model: String, target: Target<GlideDrawable>, isFirstResource: Boolean): Boolean {
                                return false
                            }

                            override fun onResourceReady(resource: GlideDrawable, model: String, target: Target<GlideDrawable>, isFromMemoryCache: Boolean, isFirstResource: Boolean): Boolean {
                                itemMovieProgressbar.visibility = View.GONE
                                return false
                            }
                        })
                        .fitCenter()
                        .crossFade()
                        .into(itemMovieImgView)
                // movieRuntime.setText(movieResultsResponse.get);
                // nowPlayingResponse.getResults()
                // movieRuntime.setText(nowPlayingResponse.get);

                // open movie details activity
                setOnClickListener {
                    val openMovieIntent = Intent(context, MovieDetailsActivity::class.java)

                    openMovieIntent.putExtra("MovieObj", movieResultsResponse)
                    context.startActivity(openMovieIntent)
                }
            }

        }
    }

    inner class EmptyViewHolder(itemView: View) : BaseViewHolder(itemView) {

        override fun clear() {}

        fun onRetryClick() {
            // btn_retry
            mCallback.onViewEmptyViewRetryClick()
        }
    }

    interface Callback {
        fun onViewEmptyViewRetryClick()
    }

    companion object {
        private val TAG = MovieNPAdapter::class.java.simpleName

        val VIEW_TYPE_EMPTY = 0
        val VIEW_TYPE_NORMAL = 1
    }

}
