package com.moviereel.ui.movie.nowplaying

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.base.BaseFragment
import com.moviereel.ui.movie.MovieDetailsActivity
import com.moviereel.utils.RecyclerItemClickListener
import com.moviereel.utils.listeners.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_movie_layout.view.*
import org.jetbrains.anko.debug
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MovieNPFragment : BaseFragment(), MovieNPView {

    companion object {
        const val TAG = "MOVIE_NP_FRAGMENT"
    }

    @Inject
    lateinit var movieNPPresenter: MovieNPPresenter<MovieNPView>

    @Inject
    lateinit var movieNPAdapter: MovieNPAdapter

    lateinit var mEndlessScrollListener: EndlessRecyclerViewScrollListener

    lateinit var mRecyclerView: RecyclerView

    /**Empty required public constructor */
    init {
        if (arguments == null) {
            arguments = Bundle()
        }
        retainInstance = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_movie_layout, container, false)

        activityComponent.inject(this)

        movieNPPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    /**
     * Used to setup views in this fragment

     * @param view
     */
    override fun setUp(view: View) {
        val mLinearLayoutManager = LinearLayoutManager(activity)
        mLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        with(view) {
            mRecyclerView = frag_movie_recycler_view_id

            frag_movie_swipe_refresh_layout_id.setColorSchemeResources(
                    R.color.dark_slate_blue,
                    R.color.dark_slate_gray,
                    R.color.dark_cyan,
                    R.color.dark_turquoise,
                    R.color.dark_sea_green)

            frag_movie_recycler_view_id.setHasFixedSize(true)
            frag_movie_recycler_view_id.layoutManager = mLinearLayoutManager
            frag_movie_recycler_view_id.itemAnimator = DefaultItemAnimator()
            frag_movie_recycler_view_id.adapter = movieNPAdapter

            mEndlessScrollListener = object : EndlessRecyclerViewScrollListener(mLinearLayoutManager) {

                override fun onLoadMore(page: Int, totalItemsCount: Int, recyclerView: RecyclerView) {
                    info { "Loading content from page $page, itemsCount: $totalItemsCount" }
                    movieNPPresenter.onLoadMoreFromApi(page)
                }
            }

            frag_movie_recycler_view_id.addOnScrollListener(mEndlessScrollListener)
        }

        movieNPPresenter.onViewInitialized()
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
        val data = ArrayList<MovieNPEntity>()
        data += movieResultsResponseList
        movieNPAdapter.addItems(data)
    }

    override fun onResume() {
        super.onResume()
        movieNPPresenter.onResume()
    }

    override fun onDestroy() {
        movieNPPresenter.onDestroy()
        super.onDestroy()
    }

}