package com.moviereel.domain.interactors

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author lusinabrian on 18/04/18.
 * @Notes
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each SingleUseCase implementation will return the result using a [DisposableObserver]
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
abstract class SingleUseCase<T, in Params> constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread) {

    private val disposables = CompositeDisposable()

    /**
     * Builds a use case observable used when the current SingleUseCase is being executed.
     * @param params
     * @return [Single]
     */
    abstract fun buildUseCaseObservable(params: Params? = null) : Single<T>

    /**
     * Executes the current use case
     * @param singleObserver a [DisposableSingleObserver] which will be listening to the [Single] build by
     * [buildUseCaseObservable] method
     * @param params (optional) used to build and execute this use case
     */
    open fun execute(singleObserver: DisposableSingleObserver<T>, params: Params? =null){
        checkNotNull(singleObserver)
        val single = buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler) as Single<T>
        addDisposable(single.subscribeWith(singleObserver))
    }

    /**
     * Dispose from current [CompositeDisposable]
     */
    fun dispose(){
        if(!disposables.isDisposed)
            disposables.dispose()
    }

    /**
     * add disposable to current [CompositeDisposable]
     * @param disposable
     */
    private fun addDisposable(disposable : Disposable){
        checkNotNull(disposable)
        checkNotNull(disposables)
        disposables.add(disposable)
    }
}