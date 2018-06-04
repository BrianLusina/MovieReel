package com.moviereel.presentation

/**
 * Every presenter in the app must either extend this interface or implement it indicating the view
 * type that must be attached
 */
interface BasePresenter<in V: BaseView>{
    /**
     * On attach is used to set the view the presenter will be interacting with
     */
    fun onAttach(baseView: V)

    /**
     * On detach is used to detach the presenter from the view
     */
    fun onDetach()
}