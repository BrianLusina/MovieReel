package com.moviereel.domain.interactors

import io.reactivex.observers.DisposableObserver

/**
 * @author lusinabrian on 24/04/18.
 * @Notes Default [DisposableObserver] base class to be used whenever you want to handle default error handling
 */
class BaseObserver<T> : DisposableObserver<T>() {
    override fun onNext(t: T) {
        // no-op required
    }

    override fun onComplete() {
        // no-op required
    }

    override fun onError(e: Throwable) {
        // no-op required
    }
}