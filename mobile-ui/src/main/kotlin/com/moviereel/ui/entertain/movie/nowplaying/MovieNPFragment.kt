package com.moviereel.ui.entertain.movie.nowplaying

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.data.db.entities.movie.MovieNowPlayingEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseFragment
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_entertainment_page.view.*
import javax.inject.Inject

class MovieNPFragment : EntertainPageBaseFragment(), MovieNPView{

    @Inject
    lateinit var movieNPPresenter: MovieNPPresenter<MovieNPView>

    @Inject
    lateinit var movieNPAdapter: MovieNPAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activityComponent.inject(this)

        super.onCreateView(inflater, container, savedInstanceState)

        movieNPPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    override fun onResume() {
        super.onResume()
        movieNPPresenter.onResume()
    }

    override fun onDestroy() {
        movieNPPresenter.onDestroy()
        super.onDestroy()
    }

    /**
     * Used to setup views in this fragment
     * @param view
     */
    override fun setUp(view: View) {
        super.setUp(view)
        with(view) {
            fragRecyclerView.adapter = movieNPAdapter

            mEndlessScrollListener = object : EndlessRecyclerViewScrollListener(mGridLinearLayoutManager) {

                override fun onLoadMore(page: Int, totalItemsCount: Int, recyclerView: RecyclerView) {
                    movieNPPresenter.onLoadMoreFromApi(page)
                }
            }

            fragRecyclerView.addOnScrollListener(mEndlessScrollListener)
        }

        movieNPPresenter.onViewInitialized()
    }

    override fun onRefresh() {
        movieNPPresenter.onSwipeRefreshTriggered()
    }

//    override fun startActivityForClickedItem(bundleKey: String, movieList: List<MovieNowPlayingEntity>) {
//        mRecyclerView.addOnItemTouchListener(RecyclerItemClickListener(activity,
//                RecyclerItemClickListener.OnItemClickListener { view, position ->
//                    activity.startActivity<MovieDetailsActivity>(
//                            bundleKey to movieList[position])
//                }))
//    }
//
//    override fun onRecyclerItemClicked(bundleKey: String, movieList: List<MovieNowPlayingEntity>) {
//        movieNPPresenter.onItemClicked(bundleKey, movieList)
//    }

    override fun updateMoviesNowPlaying(movieResultsResponseList: List<MovieNowPlayingEntity>) {
        val data = arrayListOf<MovieNowPlayingEntity>()
        data += movieResultsResponseList
        movieNPAdapter.addItemsUsingDiff(data)
    }

}