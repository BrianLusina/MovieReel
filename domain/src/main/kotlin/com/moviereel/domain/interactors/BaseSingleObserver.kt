package com.moviereel.domain.interactors

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

/**
 * @author lusinabrian on 24/04/18.
 * @Notes Base [SingleObserver] used whenever the default handling of a [Single] is required
 */
class BaseSingleObserver<T>: SingleObserver<T> {

    override fun onSubscribe(d: Disposable) { }

    override fun onSuccess(t: T) { }

    override fun onError(exception: Throwable) { }

}
