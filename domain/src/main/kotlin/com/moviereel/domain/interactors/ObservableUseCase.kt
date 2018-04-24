package com.moviereel.domain.interactors

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author lusinabrian on 24/04/18.
 * @Notes Abstract class for a use case that returns an instance of [Observable]
 * */
abstract class ObservableUseCase<T, in Params>constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread) {

    private val disposables = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params? =null) : Observable<T>
    /**
     * Executes the current use case
     * @param observer a [DisposableObserver] which will be listening to the [Single] build by
     * [buildUseCaseObservable] method
     * @param params (optional) used to build and execute this use case
     */
    open fun execute(observer: DisposableObserver<T>, params: Params? =null){
        checkNotNull(observer)
        val observable = buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
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