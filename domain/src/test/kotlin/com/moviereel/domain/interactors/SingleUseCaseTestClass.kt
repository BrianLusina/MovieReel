package com.moviereel.domain.interactors

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

class SingleUseCaseTestClass(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : SingleUseCase<Any, Params>(threadExecutor, postExecutionThread){

    override fun buildUseCaseSingle(params: Params?): Single<Any> {
        return Single.just(Any())
    }

    override fun execute(singleObserver: DisposableSingleObserver<Any>, params: Params?) {
        super.execute(singleObserver, params)
    }
}