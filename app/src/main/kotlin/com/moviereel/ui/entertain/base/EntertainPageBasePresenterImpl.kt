package com.moviereel.ui.entertain.base

import com.moviereel.data.DataManager
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.ui.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable

/**
 * @author lusinabrian on 13/09/17.
 * @Notes base presenter implementation for entertainment pages, tv and movies
 */
abstract class EntertainPageBasePresenterImpl<V : EntertainPageBaseView>(
        dataManager: DataManager, schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable)
    : EntertainPageBasePresenter<V>, BasePresenterImpl<V>(dataManager, schedulerProvider,
        compositeDisposable){

    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)
    }

    override fun onViewInitialized() {
    }

    override fun onLoadMoreFromApi(page: Int) {
    }

    override fun onSwipeRefreshTriggered() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    override fun onDetach() {
        super.onDetach()
        compositeDisposable.dispose()
    }
}