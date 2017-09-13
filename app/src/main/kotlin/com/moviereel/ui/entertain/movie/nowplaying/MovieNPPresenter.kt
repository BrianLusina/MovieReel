package com.moviereel.ui.entertain.movie.nowplaying

import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.di.scopes.PerActivity
import com.moviereel.ui.entertain.base.EntertainPageBasePresenter

/**
 * Created by lusinabrian on 26/10/16.
 * Description: Presenter interface that acts as the middleman between the [MovieNPFragment]
 * and Model layer
 */

@PerActivity
interface MovieNPPresenter<V : MovieNPView> : EntertainPageBasePresenter<V> {

    /**picks the data of the item clicked in the RecyclerView
     * start activity for the clicked movie item */
    fun onItemClicked(bundleKey: String, movieList: List<MovieNPEntity>)

}
