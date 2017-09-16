package com.moviereel.ui.entertain.movie.nowplaying

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.BuildConfig
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.base.BaseViewHolder
import com.moviereel.ui.entertain.base.EntertainPageBaseAdapter
import com.moviereel.utils.loadImageFromUrl
import kotlinx.android.synthetic.main.item_entertainment_layout.view.*
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * @author lusinabrian on 01/06/17.
 * @Notes movie now playing adapter
 */

class MovieNPAdapter
@Inject
constructor(val movieNPEntityList: ArrayList<MovieNPEntity>) : EntertainPageBaseAdapter<MovieNPEntity>(movieNPEntityList) {

    private val VIEW_TYPE_LOADING = 0
    private val VIEW_TYPE_NORMAL = 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<MovieNPEntity> {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_entertainment_layout, parent, false)
                ViewHolder(v)
            }
            VIEW_TYPE_LOADING -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.progress_dialog, parent, false)
                LoadingViewHolder(v)
            }
            else -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_empty_view, parent, false)
                EmptyViewHolder(v)
            }
        }
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder<MovieNPEntity>(itemView) {
        override fun onBind(position: Int) {
            val movieEntity = movieNPEntityList[position]

            with(itemView) {
                itemTitleTxtView.text = movieEntity.title
//                itemVoteAvgTxtView.text = movieEntity.voteAverage.toString()
                // itemMovieCategoriesTxtView
                // itemMovieRuntimeTxtView

                // glide images to image views
                itemImgView.loadImageFromUrl(context,
                        BuildConfig.IMAGE_BASE_URL + "w780" + movieEntity.posterPath,
                        itemProgressbar)

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

}
