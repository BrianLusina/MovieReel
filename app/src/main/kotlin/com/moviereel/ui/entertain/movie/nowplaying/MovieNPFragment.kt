package com.moviereel.ui.entertain.movie.nowplaying

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.detail.MovieDetailsActivity
import com.moviereel.ui.entertain.base.EntertainPageBaseFragment
import com.moviereel.utils.RecyclerItemClickListener
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_entertainment_page.*
import kotlinx.android.synthetic.main.fragment_entertainment_page.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MovieNPFragment : EntertainPageBaseFragment(), MovieNPView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var movieNPPresenter: MovieNPPresenter<MovieNPView>

    @Inject
    lateinit var movieNPAdapter: MovieNPAdapter

    lateinit var mEndlessScrollListener: EndlessRecyclerViewScrollListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        activityComponent.inject(this)

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

    override fun stopSwipeRefresh() {
        if(fragSwipeRefreshLayout.isRefreshing){
            fragSwipeRefreshLayout.isRefreshing = false
        }
    }

    override fun showApiErrorSnackbar(message: String, actionMessage: String, length: Int) {

    }

    override fun showApiErrorSnackbar(@StringRes resId: Int, @StringRes actionId: Int, length: Int) {

    }

    override fun displayToast(message: String, messageType: Int) {
        activity.toast(message)
    }

    override fun startActivityForClickedItem(bundleKey: String, movieList: List<MovieNPEntity>) {
        mRecyclerView.addOnItemTouchListener(RecyclerItemClickListener(activity,
                RecyclerItemClickListener.OnItemClickListener { view, position ->
                    activity.startActivity<MovieDetailsActivity>(
                            bundleKey to movieList[position])
                }))
    }

    override fun onRecyclerItemClicked(bundleKey: String, movieList: List<MovieNPEntity>) {
        movieNPPresenter.onItemClicked(bundleKey, movieList)
    }

    override fun updateMoviesNowPlaying(movieResultsResponseList: List<MovieNPEntity>) {
        val data = arrayListOf<MovieNPEntity>()
        data += movieResultsResponseList
        movieNPAdapter.addItems(data)
    }

}