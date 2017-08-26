package com.moviereel.ui.movie.nowplaying

import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.di.PerActivity
import com.moviereel.ui.base.BasePresenter

/**
 * Created by lusinabrian on 26/10/16.
 * Description: Presenter interface that acts as the middleman between the [MovieNPFragment]
 * and Model layer
 */

@PerActivity
interface MovieNPPresenter<V : MovieNPView> : BasePresenter<V> {

    fun onViewInitialized()

    fun onLoadMoreFromApi(page : Int)

    /**Handles what will happen when the Fragment is resumed */
    fun onResume()

    /**picks the data of the item clicked in the RecyclerView
     * start activity for the clicked movie item */
    fun onItemClicked(bundleKey: String, movieList: List<MovieNPEntity>)

    /**Handles what will happen when the Fragment is destroyed */
    fun onDestroy()
}