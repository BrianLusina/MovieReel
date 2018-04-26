package com.moviereel.domain.interactors

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

/**
 * @author lusinabrian on 24/04/18.
 * @Notes Abstract class for a use case that returns an instance of [Completable]
 */
abstract class CompletableUseCase<in Params> protected constructor(private val threadExecutor: ThreadExecutor,
                                                                   private val postExecutionThread: PostExecutionThread){

    private val subscription = Disposables.empty()

    /**
     * Builds a [Completable] which will be used when the current [CompletableUseCase] is executed.
     */
    protected abstract fun buildUseCaseObservable(params: Params): Completable

    /**
     * Executes the current use case.
     */
    open fun execute(params: Params): Completable {
        return this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
    }

    /**
     * Unsubscribes from current [Disposable].
     */
    fun unsubscribe() {
        if (!subscription.isDisposed) {
            subscription.dispose()
        }
    }
}