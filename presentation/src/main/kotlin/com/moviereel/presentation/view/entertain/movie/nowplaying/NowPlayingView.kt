package com.moviereel.presentation.view.entertain.movie.nowplaying

import com.moviereel.presentation.model.movies.NowPlayingPresenterModel
import com.moviereel.presentation.view.entertain.base.EntertainPageBaseView

interface NowPlayingView : EntertainPageBaseView {

    /**
     * Sets adapter for the recycler view
     * @param movieNowPlayingList data to use to update movie list
     */
    fun updateMoviesNowPlaying(movieNowPlayingList: List<NowPlayingPresenterModel>)

}
