package com.moviereel.domain.interactors

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver

class ObservableUseCaseTestClass(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : ObservableUseCase<Any, Params>(threadExecutor, postExecutionThread){

    override fun buildUseCaseObservable(params: Params?): Observable<Any> {
        return Observable.empty()
    }

    override fun execute(observer: DisposableObserver<Any>, params: Params?) {
        super.execute(observer, params)
    }
}