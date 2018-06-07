package com.moviereel.presentation.view.entertain.movie

import com.moviereel.presentation.view.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian
 * @notes: Presenter layer to interact with data and view
 */
class MovieFragPresenterImpl<V : MovieFragView>
@Inject
constructor() : BasePresenterImpl<V>(), MovieFragPresenter<V> {

    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)
    }

    override fun onDetach() {
        super.onDetach()
       //  compositeDisposable.dispose()
    }

}
