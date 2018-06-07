package com.moviereel.presentation.view.entertain.movie.detail

import com.moviereel.presentation.view.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian on 10/06/17.
 * @Notes
 */
class MovieDetailsPresenterImpl<V : MovieDetailsView>
@Inject
constructor() : BasePresenterImpl<V>(), MovieDetailsPresenter<V> {

    override fun onAttach(baseView: V) {
    }

    override fun onDetach() {
    }
}