package com.moviereel.domain.interactors

import io.reactivex.Completable
import io.reactivex.CompletableObserver

class TestCompletable : Completable(){
    var valuesCount = 0
    override fun subscribeActual(s: CompletableObserver?) {
        valuesCount++
    }
}