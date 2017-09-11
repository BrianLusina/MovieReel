package com.moviereel.ui.movie.nowplaying

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.base.BaseFragment
import com.moviereel.ui.detail.MovieDetailsActivity
import com.moviereel.utils.RecyclerItemClickListener
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_entertainment_page.*
import kotlinx.android.synthetic.main.fragment_entertainment_page.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MovieNPFragment : BaseFragment(), MovieNPView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var movieNPPresenter: MovieNPPresenter<MovieNPView>

    @Inject
    lateinit var movieNPAdapter: MovieNPAdapter

    lateinit var mEndlessScrollListener: EndlessRecyclerViewScrollListener

    lateinit var mRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_entertainment_page, container, false)

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
        val mGridLinearLayoutManager = GridLayoutManager(activity, resources.getInteger(R.integer.num_columns))
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