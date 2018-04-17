package com.moviereel.ui.entertain.base

import com.moviereel.ui.base.BasePresenter

/**
 * @author lusinabrian on 13/09/17.
 * @Notes base presenter for entertainment pages
 */
interface EntertainPageBasePresenter<V : EntertainPageBaseView> : BasePresenter<V> {

    fun onViewInitialized()

    fun onLoadMoreFromApi(page : Int)

    /**
     * on swipe refresh trigger callback
     * */
    fun onSwipeRefreshTriggered()

    /**Handles what will happen when the Fragment is resumed */
    fun onResume()

    /**Handles what will happen when the Fragment is destroyed */
    fun onDestroy()
}