package com.moviereel.ui.base

import com.moviereel.data.DataManager
import com.moviereel.data.io.SchedulerProvider

import javax.inject.Inject

import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.AnkoLogger

/**
 * @author lusinabrian on 01/04/17
 */

open class BasePresenterImpl<V : BaseView> @Inject
constructor(
        val dataManager: DataManager,
        val schedulerProvider: SchedulerProvider,
        val compositeDisposable: CompositeDisposable) : BasePresenter<V>, AnkoLogger {

    override val loggerTag: String
        get() = this::class.java.simpleName

    /**
     * Gets the base view
     * @return [BaseView]
     */
    lateinit var baseView: V
        private set

    override fun onAttach(mBaseView: V) {
        this.baseView = mBaseView
    }

    override fun onDetach() {
        compositeDisposable.dispose()
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
