package com.moviereel.ui.detail

import com.moviereel.data.DataManager
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.ui.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian on 10/06/17.
 * @Notes
 */
class MovieDetailsPresenterImpl<V : MovieDetailsView>
@Inject
constructor(
        mDataManager: DataManager,
        schedulerProvider: SchedulerProvider,
        mCompositeDisposable: CompositeDisposable)
    : BasePresenterImpl<V>(mDataManager, schedulerProvider, mCompositeDisposable), MovieDetailsPresenter<V> {

    override fun onAttach(mBaseView: V) {
    }

    override fun onDetach() {
    }
}