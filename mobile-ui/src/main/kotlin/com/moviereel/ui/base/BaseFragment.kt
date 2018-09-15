package com.moviereel.ui.base

import android.content.Context
import android.support.v4.app.Fragment
import android.view.View
import com.moviereel.presentation.BaseView
import org.jetbrains.anko.AnkoLogger

abstract class BaseFragment : Fragment(), BaseView, AnkoLogger{
    /**
     * Gets the base activity this fragment is attached to
     * @return [BaseActivity]
     */
    var baseActivity: BaseActivity? = null
        private set

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context
            this.baseActivity = activity
            activity.onFragmentAttached()
        }
    }

    /**
     * Checks if there is network connected
     * Returns True if the device is connected to a network, false otherwise

     * @return [Boolean]
     */
    override val isNetworkConnected: Boolean
        get() = baseActivity != null && baseActivity!!.isNetworkConnected

    /**
     * Hides keyboard
     */
    override fun hideKeyboard() {
        if (baseActivity != null) {
            baseActivity!!.hideKeyboard()
        }
    }

    /**
     * Shows a snackbar if an error has been encountered
     */
    override fun onErrorSnackBar() {
        if (baseActivity != null) {
            baseActivity!!.onErrorSnackBar()
        }
    }

    override fun showNetworkErrorSnackbar(message: String) {
        if (baseActivity != null) {
            baseActivity!!.showNetworkErrorSnackbar(message)
        }
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    /**
     * Gets the activity component of the activity this fragment is attached to
     */
//    val activityComponent: ActivityModule
//        get() = baseActivity!!.activityComponent!!

    /**
     * Used to setup views in this fragment */
    open fun setUp(view: View){}

    /**
     * Callback interface for this fragment */
    interface Callback {
        /**
         * Callback for when a fragment is attached to an activity
         */
        fun onFragmentAttached()

        /**
         * Callback for when a fragment is detached from an activity
         * @param tag the fragment tag to detach
         */
        fun onFragmentDetached(tag: String)
    }
}
