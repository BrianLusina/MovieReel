package com.moviereel.domain.interactors

import io.reactivex.observers.DisposableSingleObserver

class TestDisposableSingleObserver<T> : DisposableSingleObserver<T>(){
    var valuesCount = 0

    override fun onError(e: Throwable) {
    }

    override fun onSuccess(t: T) {
        valuesCount++
    }
}