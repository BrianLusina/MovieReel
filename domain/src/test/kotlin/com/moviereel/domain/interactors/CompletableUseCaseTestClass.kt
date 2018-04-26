package com.moviereel.domain.interactors

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import io.reactivex.Completable

class CompletableUseCaseTestClass(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : CompletableUseCase<Params>(threadExecutor, postExecutionThread){

    override fun buildUseCaseObservable(params: Params): Completable {
        return Completable.complete()
    }

    override fun execute(params: Params): Completable {
        return super.execute(params)
    }
}