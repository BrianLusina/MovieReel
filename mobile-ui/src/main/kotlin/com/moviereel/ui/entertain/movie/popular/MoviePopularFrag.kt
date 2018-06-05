package com.moviereel.ui.entertain.movie.popular

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.data.db.entities.movie.MoviePopularEntity
import com.moviereel.presentation.view.entertain.movie.popular.MoviePopularPresenter
import com.moviereel.presentation.view.entertain.movie.popular.MoviePopularView
import com.moviereel.ui.entertain.base.EntertainPageBaseFragment
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_entertainment_page.view.*
import javax.inject.Inject

/**
 * @author lusinabrian on 12/04/17
 */

class MoviePopularFrag : EntertainPageBaseFragment(), MoviePopularView {

    @Inject
    lateinit var moviePopPresenter: MoviePopularPresenter<MoviePopularView>

    @Inject
    lateinit var moviePopularAdapter: MoviePopularAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activityComponent.inject(this)

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
            fragRecyclerView.adapter = moviePopularAdapter

            mEndlessScrollListener = object : EndlessRecyclerViewScrollListener(mGridLinearLayoutManager) {

                override fun onLoadMore(page: Int, totalItemsCount: Int, recyclerView: RecyclerView) {
                    moviePopPresenter.onLoadMoreFromApi(page)
                }
            }

            fragRecyclerView.addOnScrollListener(mEndlessScrollListener)
        }

        moviePopPresenter.onViewInitialized()
    }

    override fun onRefresh() {
        moviePopPresenter.onSwipeRefreshTriggered()
    }

    override fun updatePopularMovies(popularMovieList: List<MoviePopularEntity>) {
        val data = arrayListOf<MoviePopularEntity>()
        data += popularMovieList
        moviePopularAdapter.addItemsUsingDiff(data)
    }
}
