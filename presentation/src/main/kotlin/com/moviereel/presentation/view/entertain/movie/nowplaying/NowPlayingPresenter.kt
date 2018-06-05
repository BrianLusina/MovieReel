package com.moviereel.presentation.view.entertain.movie.nowplaying

import com.moviereel.presentation.view.entertain.base.EntertainPageBasePresenter

/**
 * Created by lusinabrian on 26/10/16.
 * Description: Presenter interface that acts as the middleman between the [MovieNPFragment]
 * and Model layer
 */

interface NowPlayingPresenter<V : NowPlayingView> : EntertainPageBasePresenter<V> {

    /**picks the data of the item clicked in the RecyclerView
     * start activity for the clicked movie item */
    // fun onItemClicked(bundleKey: String, movieList: List<MovieNowPlayingEntity>)
}
