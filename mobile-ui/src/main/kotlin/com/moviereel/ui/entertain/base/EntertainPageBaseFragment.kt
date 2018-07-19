package com.moviereel.ui.entertain.base

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.presentation.view.entertain.base.EntertainPageBaseView
import com.moviereel.ui.base.BaseFragment
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_entertainment_page.view.*

/**
 * @author lusinabrian on 13/09/17.
 * @Notes base fragment for movie pages
 */
abstract class EntertainPageBaseFragment : BaseFragment(), EntertainPageBaseView, SwipeRefreshLayout.OnRefreshListener{

    lateinit var recyclerView: RecyclerView
    lateinit var gridLinearLayoutManager : GridLayoutManager
    lateinit var rootView : View

    lateinit var endlessScrollListener: EndlessRecyclerViewScrollListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_entertainment_page, container, false)
        setUp(rootView)

        return rootView
    }

    /**
     * Used to setup views in this fragment
     * @param view
     */
    override fun setUp(view: View) {
        gridLinearLayoutManager = GridLayoutManager(activity, resources.getInteger(R.integer.num_columns))
        val ctx = this

        gridLinearLayoutManager.orientation = GridLayoutManager.VERTICAL
        with(view) {
            recyclerView = recycler_view_entertainment

            swipe_refresh_layout_entertainment.setColorSchemeResources(R.color.dark_slate_blue,
                    R.color.dark_slate_gray, R.color.dark_cyan, R.color.dark_turquoise,
                    R.color.dark_sea_green)
            swipe_refresh_layout_entertainment.setOnRefreshListener(ctx)

            recycler_view_entertainment.setHasFixedSize(true)
            recycler_view_entertainment.layoutManager = gridLinearLayoutManager
            recycler_view_entertainment.itemAnimator = DefaultItemAnimator()
        }
    }

    override fun stopSwipeRefresh() {
        with(rootView){
            if (swipe_refresh_layout_entertainment.isRefreshing){
                swipe_refresh_layout_entertainment.isRefreshing = false
            }
        }
    }

    override fun showApiErrorSnackbar() {

    }

    override fun displayToast() {
       // activity.toast(message)
    }

}