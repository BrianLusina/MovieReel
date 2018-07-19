package com.moviereel.ui.entertain.movie.upcoming

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.presentation.view.entertain.movie.upcoming.UpcomingPresenter
import com.moviereel.presentation.view.entertain.movie.upcoming.UpcomingView
import com.moviereel.ui.entertain.base.EntertainPageBaseFragment
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_entertainment_page.view.*
import javax.inject.Inject

/**
 * @author lusinabrian on 12/04/17
 */

class MovieUpcomingFrag : EntertainPageBaseFragment(), UpcomingView {

    @Inject
    lateinit var upcomingPresenter: UpcomingPresenter<UpcomingView>

//    @Inject
//    lateinit var movieUpcomingAdapter: MovieUpcomingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // activityComponent.inject(this)

        super.onCreateView(inflater, container, savedInstanceState)

        upcomingPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    /**
     * Used to setup views in this fragment
     */
    override fun setUp(view: View) {
        super.setUp(view)
        with(view) {

            // recycler_view_entertainment.adapter

            endlessScrollListener = object : EndlessRecyclerViewScrollListener(gridLinearLayoutManager) {

                override fun onLoadMore(page: Int, totalItemsCount: Int, recyclerView: RecyclerView) {
                    upcomingPresenter.onLoadMoreFromApi(page)
                }
            }

            recycler_view_entertainment.addOnScrollListener(endlessScrollListener)
        }

        upcomingPresenter.onViewInitialized()
    }

    override fun onResume() {
        super.onResume()
        upcomingPresenter.onResume()
    }

    override fun onDestroy() {
        upcomingPresenter.onDestroy()
        super.onDestroy()
    }

    override fun onRefresh() {
        upcomingPresenter.onSwipeRefreshTriggered()
    }

//    override fun updateMoviesUpcoming(movieUpcomingList: List<MovieUpcomingEntity>) {
//        val data = arrayListOf<MovieUpcomingEntity>()
//        data += movieUpcomingList
//        movieUpcomingAdapter.addItemsUsingDiff(data)
//    }
}
