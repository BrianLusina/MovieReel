package com.moviereel.presentation.view.entertain.base

import com.moviereel.presentation.view.base.BasePresenterImpl

/**
 * @author lusinabrian on 13/09/17.
 * @Notes base presenter implementation for entertainment pages, tv and movies
 */
abstract class EntertainPageBasePresenterImpl<V : EntertainPageBaseView> : EntertainPageBasePresenter<V>, BasePresenterImpl<V>(){

    var remote = true
    override fun onAttach(baseView: V) {
        super.onAttach(baseView)
        if(isViewAttached){
            remote = baseView.isNetworkConnected
        }
    }
}