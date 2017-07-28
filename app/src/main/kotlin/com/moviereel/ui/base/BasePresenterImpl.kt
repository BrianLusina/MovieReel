package com.moviereel.ui.base

import com.moviereel.data.DataManager

import javax.inject.Inject

import io.reactivex.disposables.CompositeDisposable

/**
 * @author lusinabrian on 01/04/17
 */

open class BasePresenterImpl<V : BaseView> @Inject
constructor(
        /**
         * Gets the data manager interface of the application
         * @return [DataManager]
         */
        val dataManager: DataManager,
        /**
         * Returns [CompositeDisposable]
         */
        val compositeDisposable: CompositeDisposable) : BasePresenter<V> {
    /**
     * Gets the base view
     * @return [BaseView]
     */
    var baseView: V? = null
        private set

    override fun onAttach(mBaseView: V) {
        this.baseView = mBaseView
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        baseView = null
    }

    /**
     * Checks if the view has been attached */
    val isViewAttached: Boolean
        get() = baseView != null

    /**
     * Checks if the view has been attached
     * @throws BaseViewNotAttachedException error that is thrown when the view is not attached.
     * *
     */
    fun checkViewAttached() {
        if (!isViewAttached) {
            throw BaseViewNotAttachedException()
        }
    }

    /**
     * Custom runtime exception that is thrown when an a request of data is made to the presenter before
     * attaching the view.
     */
    class BaseViewNotAttachedException : RuntimeException("Please call Presenter.onAttach(BaseView) before requesting data to Presenter")

    companion object {
        private val TAG = BasePresenterImpl::class.java.simpleName
    }
}
