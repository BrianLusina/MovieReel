package com.moviereel.ui.movie

import com.moviereel.data.DataManager
import com.moviereel.ui.base.BasePresenter
import com.moviereel.ui.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian on 10/06/17.
 * @Notes
 */
class MovieDetailsPresenterImpl<V : MovieDetailsView> @Inject constructor(mDataManager: DataManager, mCompositeDisposable: CompositeDisposable) : BasePresenterImpl<V>(mDataManager, mCompositeDisposable), MovieDetailsPresenter<V> {

    override fun onAttach(mBaseView: V) {
    }

    override fun onDetach() {
    }
}