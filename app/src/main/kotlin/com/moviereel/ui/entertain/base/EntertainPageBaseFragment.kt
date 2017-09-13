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
import com.moviereel.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_entertainment_page.view.*

/**
 * @author lusinabrian on 13/09/17.
 * @Notes base fragment for movie pages
 */
abstract class EntertainPageBaseFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener{

    lateinit var mRecyclerView: RecyclerView
    lateinit var mGridLinearLayoutManager : GridLayoutManager
    lateinit var rootView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_entertainment_page, container, false)

        setUp(rootView)

        return rootView
    }

    override fun onResume() {
        super.onResume()
    }

    /**
     * Used to setup views in this fragment

     * @param view
     */
    override fun setUp(view: View) {
        mGridLinearLayoutManager = GridLayoutManager(activity, resources.getInteger(R.integer.num_columns))
        val ctx = this

        mGridLinearLayoutManager.orientation = GridLayoutManager.VERTICAL
        with(view) {
            mRecyclerView = fragRecyclerView

            fragSwipeRefreshLayout.setColorSchemeResources(R.color.dark_slate_blue,
                    R.color.dark_slate_gray, R.color.dark_cyan, R.color.dark_turquoise,
                    R.color.dark_sea_green)
            fragSwipeRefreshLayout.setOnRefreshListener(ctx)

            fragRecyclerView.setHasFixedSize(true)
            fragRecyclerView.layoutManager = mGridLinearLayoutManager
            fragRecyclerView.itemAnimator = DefaultItemAnimator()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}