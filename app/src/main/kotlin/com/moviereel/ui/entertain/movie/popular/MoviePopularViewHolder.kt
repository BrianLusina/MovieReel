package com.moviereel.ui.entertain.movie.popular

import android.view.View
import com.moviereel.BuildConfig
import com.moviereel.data.db.entities.movie.MoviePEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseViewHolder
import com.moviereel.utils.loadImageFromUrl
import kotlinx.android.synthetic.main.item_entertainment_layout.view.*
import org.jetbrains.anko.toast

/**
 * @author lusinabrian on 16/09/17.
 * @Notes View holder for popular movies
 */
class MoviePopularViewHolder(itemView: View, val moviePopularList: ArrayList<MoviePEntity>)
    : EntertainPageBaseViewHolder<MoviePEntity>(itemView) {

    override fun onBind(position: Int) {
        val moviePopularEntity = moviePopularList[position]

        with(itemView) {
            itemTitleTxtView.text = moviePopularEntity.title
//                itemVoteAvgTxtView.text = moviePopularEntity.voteAverage.toString()
            // itemMovieCategoriesTxtView
            // itemMovieRuntimeTxtView

            // glide images to image views
            itemImgView.loadImageFromUrl(context,
                    BuildConfig.IMAGE_BASE_URL + "w780" + moviePopularEntity.posterPath,
                    itemProgressbar)

            // movieRuntime.setText(movieResultsResponse.get);
            // nowPlayingResponse.getResults()
            // movieRuntime.setText(nowPlayingResponse.get);

            // open movie details activity
            setOnClickListener {
                context.toast("$moviePopularEntity")
//                    context.startActivity<MovieDetailsActivity>(
//                            "MovieObj" to moviePopularEntity
//                    )
            }
        }
    }
}