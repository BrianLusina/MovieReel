package com.moviereel.ui.entertain.movie.upcoming

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.data.db.entities.movie.MovieUpcomingEntity
import com.moviereel.presentation.view.entertain.movie.upcoming.MovieUpcomingPresenter
import com.moviereel.presentation.view.entertain.movie.upcoming.MovieUpcomingView
import com.moviereel.ui.entertain.base.EntertainPageBaseFragment
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_entertainment_page.view.*
import javax.inject.Inject

/**
 * @author lusinabrian on 12/04/17
 */

class MovieUpcomingFrag : EntertainPageBaseFragment(), MovieUpcomingView {

    @Inject
    lateinit var movieUpcomingPresenter: MovieUpcomingPresenter<MovieUpcomingView>

    @Inject
    lateinit var movieUpcomingAdapter: MovieUpcomingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activityComponent.inject(this)

        super.onCreateView(inflater, container, savedInstanceState)

        movieUpcomingPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    /**
     * Used to setup views in this fragment
     */
    override fun setUp(view: View) {
        super.setUp(view)
        with(view) {
            fragRecyclerView.adapter = movieUpcomingAdapter

            mEndlessScrollListener = object : EndlessRecyclerViewScrollListener(mGridLinearLayoutManager) {

                override fun onLoadMore(page: Int, totalItemsCount: Int, recyclerView: RecyclerView) {
                    movieUpcomingPresenter.onLoadMoreFromApi(page)
                }
            }

            fragRecyclerView.addOnScrollListener(mEndlessScrollListener)
        }

        movieUpcomingPresenter.onViewInitialized()
    }

    override fun onResume() {
        super.onResume()
        movieUpcomingPresenter.onResume()
    }

    override fun onDestroy() {
        movieUpcomingPresenter.onDestroy()
        super.onDestroy()
    }

    override fun onRefresh() {
        movieUpcomingPresenter.onSwipeRefreshTriggered()
    }

    override fun updateMoviesUpcoming(movieUpcomingList: List<MovieUpcomingEntity>) {
        val data = arrayListOf<MovieUpcomingEntity>()
        data += movieUpcomingList
        movieUpcomingAdapter.addItemsUsingDiff(data)
    }
}
