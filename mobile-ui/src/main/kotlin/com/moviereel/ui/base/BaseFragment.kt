package com.moviereel.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.moviereel.presentation.BaseView
import org.jetbrains.anko.AnkoLogger

/**
 * @author lusinabrian on 01/04/17
 */

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
            val mBaseActivity = context
            this.baseActivity = mBaseActivity
            mBaseActivity.onFragmentAttached()
        }
    }

    /**
     * Called to do initial creation of a fragment.  This is called after
     * [Fragment.onAttach] and before
     * [Fragment.onCreateView].
     *
     *
     *
     * Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, see [.onActivityCreated].
     *
     *
     *
     * Any restored child fragments will be created before the base
     * `Fragment.onCreate` method returns.

     * @param savedInstanceState If the fragment is being re-created from
     * *                           a previous saved state, this is the state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    protected abstract fun setUp(view: View)

    /**
     * before destroying the fragment, check if the attached view in the hierarchy are still bound and
     * unbind them */
    override fun onDestroy() {
        super.onDestroy()
    }

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
