package com.moviereel.ui.entertain.movie.popular

import com.moviereel.data.DataManager
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.ui.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian
 * @notes: Presenter layer to interact with data and view
 */
class MoviePopularPresenterImpl<V : MoviePopularView>
@Inject
constructor(mDataManager: DataManager, mCompositeDisposable: CompositeDisposable,
            mSchedulerProvider: SchedulerProvider) : BasePresenterImpl<V>(mDataManager,
        mSchedulerProvider, mCompositeDisposable),
        MoviePopularPresenter<V> {

    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)
    }

    override fun onDetach() {
        super.onDetach()
        compositeDisposable.dispose()
    }
}
