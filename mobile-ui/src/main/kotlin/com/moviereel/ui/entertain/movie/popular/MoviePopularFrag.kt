package com.moviereel.ui.entertain.movie.popular

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.presentation.view.entertain.movie.popular.PopularPresenter
import com.moviereel.presentation.view.entertain.movie.popular.PopularView
import com.moviereel.ui.entertain.base.EntertainPageBaseFragment
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import org.koin.android.ext.android.inject

/**
 * @author lusinabrian on 12/04/17
 */

class MoviePopularFrag : EntertainPageBaseFragment(), PopularView {

    val moviePopPresenter: PopularPresenter<PopularView> by inject()

//    @Inject
//    lateinit var moviePopularAdapter: MoviePopularAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        moviePopPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    /**
     * Used to setup views in this fragment
     */
    override fun setUp(view: View) {
        super.setUp(view)
        with(view) {
            // fragRecyclerView.adapter = moviePopularAdapter

            endlessScrollListener = object : EndlessRecyclerViewScrollListener(gridLinearLayoutManager) {

                override fun onLoadMore(page: Int, totalItemsCount: Int, recyclerView: RecyclerView) {
                    moviePopPresenter.onLoadMoreFromApi(page)
                }
            }

            //fragRecyclerView.addOnScrollListener(endlessScrollListener)
        }

        moviePopPresenter.onViewInitialized()
    }

    override fun onRefresh() {
        moviePopPresenter.onSwipeRefreshTriggered()
    }

//
//
//    override fun updatePopularMovies(popularMovieList: List<MoviePopularEntity>) {
//        val data = arrayListOf<MoviePopularEntity>()
//        data += popularMovieList
//        moviePopularAdapter.addItemsUsingDiff(data)
//    }
}
