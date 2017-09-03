package com.moviereel.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.moviereel.BuildConfig
import com.moviereel.R
import com.moviereel.data.db.entities.BaseEntity
import com.moviereel.ui.base.BaseRecyclerAdapter
import com.moviereel.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_entertainment_layout.view.*
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * @author lusinabrian on 27/08/17.
 * @Notes Adapter for all movie types
 */
class MovieAdapter
@Inject
constructor(val movieEntityList: ArrayList<BaseEntity>) : BaseRecyclerAdapter<BaseEntity>(movieEntityList) {

    private val VIEW_TYPE_LOADING = 0
    private val VIEW_TYPE_NORMAL = 1

    lateinit var mCallback: Callback

    fun setCallback(callback: Callback) {
        mCallback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseEntity> {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.item_entertainment_layout, parent, false)
                ViewHolder(v)
            }
            VIEW_TYPE_LOADING -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.progress_dialog, parent, false)
                LoadingViewHolder(v)
            }
            else -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.item_empty_view, parent, false)
                EmptyViewHolder(v)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (movieEntityList.size > 0) {
            VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_LOADING
        }

    }

    override fun getItemCount(): Int {
        return movieEntityList.size
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder<BaseEntity>(itemView) {

        override fun onBind(position: Int) {
            val movieEntity = movieEntityList[position]

            with(itemView) {

//                itemTitleTxtView.text = movieEntity.title
//                itemVoteAvgTxtView.text = movieEntity.voteAverage.toString()

               // itemMovieCategoriesTxtView
                // itemMovieRuntimeTxtView
                // glide images to image views
                Glide.with(context)
                        .load(BuildConfig.IMAGE_BASE_URL + movieEntity.posterPath)
                        .listener(object : RequestListener<String, GlideDrawable> {
                            override fun onException(e: Exception, model: String, target: Target<GlideDrawable>, isFirstResource: Boolean): Boolean {
                                return false
                            }

                            override fun onResourceReady(resource: GlideDrawable, model: String, target: Target<GlideDrawable>, isFromMemoryCache: Boolean, isFirstResource: Boolean): Boolean {
                                itemProgressbar.visibility = View.GONE
                                return false
                            }
                        })
                        .fitCenter()
                        .crossFade()
                        .thumbnail(1F)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(itemImgView)
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

    inner class EmptyViewHolder(itemView: View) : BaseViewHolder<BaseEntity>(itemView) {

        fun onRetryClick() {
            // btn_retry
            mCallback.onViewEmptyViewRetryClick()
        }
    }

    inner class LoadingViewHolder(itemView: View) : BaseViewHolder<BaseEntity>(itemView)

    interface Callback {
        fun onViewEmptyViewRetryClick()
    }

}
