package com.moviereel.ui.movie.nowplaying

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.moviereel.BuildConfig
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.base.BaseRecyclerAdapter
import com.moviereel.ui.base.BaseViewHolder
import com.moviereel.ui.movie.MovieDetailsActivity
import com.moviereel.utils.CommonUtils.adapterVHInflater
import kotlinx.android.synthetic.main.item_movie_layout.view.*
import javax.inject.Inject

/**
 * @author lusinabrian on 01/06/17.
 * @Notes
 */

class MovieNPAdapter
@Inject
constructor(
        val movieResultsResponseList: ArrayList<MovieNPEntity>) : BaseRecyclerAdapter<MovieNPEntity>(movieResultsResponseList) {

    val VIEW_TYPE_LOADING = 0
    val VIEW_TYPE_NORMAL = 1

    lateinit var mCallback: Callback

    fun setCallback(callback: Callback) {
        mCallback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MovieNPEntity> {
        when (viewType) {
            VIEW_TYPE_NORMAL -> return ViewHolder(adapterVHInflater(parent, R.layout.item_movie_layout))
            VIEW_TYPE_LOADING -> return LoadingViewHolder(adapterVHInflater(parent, R.layout.progress_dialog))
            else -> return EmptyViewHolder(
                    adapterVHInflater(parent, R.layout.item_empty_view))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (movieResultsResponseList.size > 0) {
            return VIEW_TYPE_NORMAL
        } else {
            return VIEW_TYPE_LOADING
        }

    }

    override fun getItemCount(): Int {
        if (movieResultsResponseList.size > 0) {
            return movieResultsResponseList.size
        } else {
            return 1
        }
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder<MovieNPEntity>(itemView) {

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

    inner class EmptyViewHolder(itemView: View) : BaseViewHolder<MovieNPEntity>(itemView) {

        fun onRetryClick() {
            // btn_retry
            mCallback.onViewEmptyViewRetryClick()
        }
    }

    inner class LoadingViewHolder(itemView: View) : BaseViewHolder<MovieNPEntity>(itemView)

    interface Callback {
        fun onViewEmptyViewRetryClick()
    }

}
