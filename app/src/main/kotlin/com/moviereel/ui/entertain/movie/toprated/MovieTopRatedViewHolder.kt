package com.moviereel.ui.entertain.movie.toprated

import android.view.View
import com.moviereel.BuildConfig
import com.moviereel.data.db.entities.movie.MovieTopRatedEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseViewHolder
import com.moviereel.utils.loadImageFromUrl
import kotlinx.android.synthetic.main.item_entertainment_layout.view.*
import org.jetbrains.anko.toast

/**
 * @author lusinabrian on 18/09/17.
 * @Notes
 */
class MovieTopRatedViewHolder(itemView: View, val movieTopRatedList: ArrayList<MovieTopRatedEntity>)
    : EntertainPageBaseViewHolder<MovieTopRatedEntity>(itemView) {

    override fun onBind(position: Int) {
        val movieTopRatedEntity = movieTopRatedList[position]

        with(itemView) {
            itemTitleTxtView.text = movieTopRatedEntity.title
//                itemVoteAvgTxtView.text = movieTopRatedEntity.voteAverage.toString()
            // itemMovieCategoriesTxtView
            // itemMovieRuntimeTxtView

            // glide images to image views
            itemImgView.loadImageFromUrl(context,
                    BuildConfig.IMAGE_BASE_URL + "w780" + movieTopRatedEntity.posterPath,
                    itemProgressbar)

            // movieRuntime.setText(movieResultsResponse.get);
            // nowPlayingResponse.getResults()
            // movieRuntime.setText(nowPlayingResponse.get);

            // open movie details activity
            setOnClickListener {
                context.toast("$movieTopRatedEntity")
//                    context.startActivity<MovieDetailsActivity>(
//                            "MovieObj" to movieTopRatedEntity
//                    )
            }
        }
    }
}