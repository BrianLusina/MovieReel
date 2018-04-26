package com.moviereel.domain.interactors

import io.reactivex.observers.DisposableObserver

class TestDisposableObserver<T> : DisposableObserver<T>(){
    var valuesCount = 0

    override fun onComplete() {
    }

    override fun onError(e: Throwable) {
    }

    override fun onNext(t: T) {
        valuesCount++
    }
}