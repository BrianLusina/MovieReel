package com.moviereel.ui.entertain.movie.nowplaying

import android.view.View
import com.moviereel.BuildConfig
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseViewHolder
import com.moviereel.utils.loadImageFromUrl
import kotlinx.android.synthetic.main.item_entertainment_layout.view.*
import org.jetbrains.anko.toast

/**
 * @author lusinabrian on 16/09/17.
 * @Notes
 */
class MovieNpViewHolder(itemView: View, val movieNPEntityList: ArrayList<MovieNPEntity>)
    : EntertainPageBaseViewHolder<MovieNPEntity>(itemView) {
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