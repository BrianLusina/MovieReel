package com.moviereel.ui.movie.nowplaying

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
import kotlinx.android.synthetic.main.item_movie_layout.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * @author lusinabrian on 01/06/17.
 * @Notes
 */

class MovieNPAdapter
@Inject
constructor(
        val movieNPEntityList: ArrayList<MovieNPEntity>) : BaseRecyclerAdapter<MovieNPEntity>(movieNPEntityList) {

    val VIEW_TYPE_LOADING = 0
    val VIEW_TYPE_NORMAL = 1

    lateinit var mCallback: Callback

    fun setCallback(callback: Callback) {
        mCallback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MovieNPEntity> {
        when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_layout, parent, false)
                return ViewHolder(v)
            }
            VIEW_TYPE_LOADING -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.progress_dialog, parent, false)
                return LoadingViewHolder(v)
            }
            else -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.item_empty_view, parent, false)
                return EmptyViewHolder(v)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (movieNPEntityList.size > 0) {
            return VIEW_TYPE_NORMAL
        } else {
            return VIEW_TYPE_LOADING
        }

    }

    override fun getItemCount(): Int {
        return movieNPEntityList.size
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder<MovieNPEntity>(itemView) {

        override fun onBind(position: Int) {
            val movieEntity = movieNPEntityList[position]

            with(itemView) {
                itemMovieTitleTxtView.text = movieEntity.title
                itemMovieVoteAvgTxtView.text = movieEntity.voteAverage.toString()
                // itemMovieCategoriesTxtView
                // itemMovieRuntimeTxtView
                // glide images to image views
                Glide.with(context)
                        .load(BuildConfig.POSTER_PATH + movieEntity.posterPath)
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
                    context.toast("$movieEntity")
//                    context.startActivity<MovieDetailsActivity>(
//                            "MovieObj" to movieEntity
//                    )
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