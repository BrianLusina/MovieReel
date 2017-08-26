package com.moviereel.ui.movie

import com.moviereel.data.DataManager
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.ui.base.BasePresenterImpl
import com.moviereel.ui.movie.MovieFragPresenter
import com.moviereel.ui.movie.MovieFragView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian
 * @notes: Presenter layer to interact with data and view
 */
class MovieFragPresenterImpl<V : MovieFragView>
@Inject
constructor(mDatamanager: DataManager, mCompositeDisposable: CompositeDisposable,
            mSchedulerProvider: SchedulerProvider
) : BasePresenterImpl<V>(mDatamanager, mSchedulerProvider, mCompositeDisposable),
        MovieFragPresenter<V> {

    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)
    }

    override fun onDetach() {
        super.onDetach()
        compositeDisposable.dispose()
    }

}
