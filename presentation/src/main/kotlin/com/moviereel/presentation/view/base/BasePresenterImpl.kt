package com.moviereel.presentation.view.base

import com.moviereel.presentation.BasePresenter
import com.moviereel.presentation.BaseView
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.AnkoLogger

open class BasePresenterImpl<V : BaseView>
@Inject
constructor(private val compositeDisposable: CompositeDisposable) : BasePresenter<V>, AnkoLogger {

    /**
     * Gets the base view
     * @return [BaseView]
     */
    lateinit var baseView: V
        private set

    override val loggerTag: String
        get() = this::class.java.simpleName

    override fun onAttach(baseView: V) {
        this.baseView = baseView
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
