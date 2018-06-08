package com.moviereel.ui.entertain.movie.nowplaying

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.presentation.model.movies.NowPlayingPresenterModel
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingPresenter
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingView
import com.moviereel.ui.entertain.base.EntertainPageBaseFragment
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import javax.inject.Inject

class NowPlayingFragment : EntertainPageBaseFragment(), NowPlayingView {

    @Inject
    lateinit var nowPlayingPresenter: NowPlayingPresenter<NowPlayingView>

    @Inject
    lateinit var nowPlayingAdapter: NowPlayingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activityComponent.inject(this)

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
        with(view) {
            // fragRecyclerView.adapter = nowPlayingAdapter

            mEndlessScrollListener = object : EndlessRecyclerViewScrollListener(mGridLinearLayoutManager) {

                override fun onLoadMore(page: Int, totalItemsCount: Int, recyclerView: RecyclerView) {
                    nowPlayingPresenter.onLoadMoreFromApi(page)
                }
            }

            // fragRecyclerView.addOnScrollListener(mEndlessScrollListener)
        }

        nowPlayingPresenter.onViewInitialized()
    }

    override fun onRefresh() {
        nowPlayingPresenter.onSwipeRefreshTriggered()
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
//        nowPlayingPresenter.onItemClicked(bundleKey, movieList)
//    }

    override fun updateMoviesNowPlaying(movieNowPlayingList: List<NowPlayingPresenterModel>) {
//        val data = arrayListOf<MovieNowPlayingEntity>()
//        data += movieResultsResponseList
//        nowPlayingAdapter.addItemsUsingDiff(data)
    }

}