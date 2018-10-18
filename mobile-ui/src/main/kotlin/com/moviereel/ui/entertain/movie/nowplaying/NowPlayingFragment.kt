package com.moviereel.ui.entertain.movie.nowplaying

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.mapper.movies.NowPlayingViewMapper
import com.moviereel.presentation.model.movies.NowPlayingPresenterModel
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingPresenter
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingView
import com.moviereel.ui.entertain.base.EntertainPageBaseFragment
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import org.koin.android.ext.android.inject
import javax.inject.Inject

class NowPlayingFragment : EntertainPageBaseFragment(), NowPlayingView {

    val nowPlayingPresenter: NowPlayingPresenter<NowPlayingView> by inject()
    val nowPlayingAdapter: NowPlayingAdapter by inject()
    val nowPlayingMapper : NowPlayingViewMapper by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        nowPlayingPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    override fun onResume() {
        super.onResume()
        nowPlayingPresenter.onResume()
    }

    override fun onDestroy() {
        nowPlayingPresenter.onDestroy()
        super.onDestroy()
    }

    /**
     * Used to setup views in this fragment
     * @param view
     */
    override fun setUp(view: View) {
        super.setUp(view)
        recyclerView.adapter = nowPlayingAdapter

        endlessScrollListener = object : EndlessRecyclerViewScrollListener(gridLinearLayoutManager) {

            override fun onLoadMore(page: Int, totalItemsCount: Int, recyclerView: RecyclerView) {
                nowPlayingPresenter.onLoadMoreFromApi(page)
            }
        }

        recyclerView.addOnScrollListener(endlessScrollListener)

        nowPlayingPresenter.onViewInitialized()
    }

    override fun onRefresh() {
        nowPlayingPresenter.onSwipeRefreshTriggered()
    }

//    override fun startActivityForClickedItem(bundleKey: String, movieList: List<MovieNowPlayingEntity>) {
//        recyclerView.addOnItemTouchListener(RecyclerItemClickListener(activity,
//                RecyclerItemClickListener.OnItemClickListener { view, position ->
//                    activity.startActivity<MovieDetailsActivity>(
//                            bundleKey to movieList[position])
//                }))
//    }
//
//    override fun onRecyclerItemClicked(bundleKey: String, movieList: List<MovieNowPlayingEntity>) {
//        nowPlayingPresenter.onItemClicked(bundleKey, movieList)
//    }

    override fun updateMoviesNowPlaying(movieNowPlayingList: List<NowPlayingPresenterModel>) {
        val data = movieNowPlayingList.map {
            nowPlayingMapper.mapToViewModel(it)
        }

        nowPlayingAdapter.addItemsUsingDiff(ArrayList(data))
    }

}