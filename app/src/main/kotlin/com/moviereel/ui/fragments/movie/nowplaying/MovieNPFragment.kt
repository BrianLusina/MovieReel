package com.moviereel.ui.fragments.movie.nowplaying

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.CoordinatorLayout
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.data.api.model.movie.response.MovieResultsResponse
import com.moviereel.data.db.models.movie.MovieNowPlayingModel
import com.moviereel.ui.base.BaseFragment
import com.moviereel.utils.ClassPreamble
import com.moviereel.utils.RecyclerItemClickListener
import com.sdsmdg.tastytoast.TastyToast

import javax.inject.Inject

import butterknife.ButterKnife

@ClassPreamble(author = "Brian Lusina", date = "22/08/16", lastModified = "18/3/2017", lastModifiedBy = "Brian Lusina", currentRevision = 3, briefDescription = "Fragment to display the latest movies", reviewers = arrayOf("Brian Lusina"))
class MovieNPFragment : BaseFragment(), MovieNPView {

    lateinit internal var mRecyclerView: RecyclerView
    lateinit internal var coordinatorLayout: CoordinatorLayout
    lateinit internal var mSwipeRefreshLayout: SwipeRefreshLayout

    @Inject
    lateinit var movieNPPresenter: MovieNPPresenter<MovieNPView>

    @Inject
    lateinit var movieNPAdapter: MovieNPAdapter

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

        setUnbinder(ButterKnife.bind(this, rootView))

        movieNPPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    /**
     * Used to setup views in this fragment

     * @param view
     */
    override fun setUp(view: View) {
        mRecyclerView = view.findViewById(R.id.frag_movie_recycler_view_id) as RecyclerView
        coordinatorLayout = view.findViewById(R.id.frag_movie_coordinator_layout) as CoordinatorLayout
        mSwipeRefreshLayout = view.findViewById(R.id.frag_movie_swipe_refresh_layout_id) as SwipeRefreshLayout

        //TODO: set the swipe refresh layout to fetch more data
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.dark_slate_blue,
                R.color.dark_slate_gray,
                R.color.dark_cyan,
                R.color.dark_turquoise,
                R.color.dark_sea_green)

        val mLinearLayoutManager = LinearLayoutManager(activity)
        mLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = mLinearLayoutManager
        mRecyclerView.itemAnimator = DefaultItemAnimator()

        // mRecyclerView.setAdapter(movieNPAdapter);
        movieNPPresenter.onViewInitialized()

        mRecyclerView.adapter = movieNPAdapter
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //implement item click listener
        /*        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                (view1, position) -> startActivityForClickedItem(MOVIE_OBJ, position)));*/
    }

    override fun showApiErrorSnackbar(message: String, actionMessage: String, length: Int) {

    }

    override fun showApiErrorSnackbar(@StringRes resId: Int, @StringRes actionId: Int, length: Int) {

    }

    override fun displayToast(message: String, messageType: Int) {
        TastyToast.makeText(activity, message, messageType, TastyToast.LENGTH_SHORT)
    }

    override fun startActivityForClickedItem(bundleKey: String, movieList: List<MovieNowPlayingModel>) {
        mRecyclerView.addOnItemTouchListener(RecyclerItemClickListener(activity,
                RecyclerItemClickListener.OnItemClickListener { view, position ->
                    //Intent showMovieDet = new Intent(getActivity(),MovieDetails.class);
                    // TODO: 10/05/17 bundle
                    //showMovieDet.putExtra(bundleKey, movieList.get(position));
                    //startActivity(showMovieDet);
                }))
    }

    override fun onRecyclerItemClicked(bundleKey: String, movieList: List<MovieNowPlayingModel>) {
        movieNPPresenter.onItemClicked(bundleKey, movieList)
    }

    override fun updateMoviesNowPlaying(movieResultsResponseList: List<MovieResultsResponse>) {
        movieNPAdapter.addItems(movieResultsResponseList)
    }

    override fun onResume() {
        super.onResume()
        movieNPPresenter.onResume()
    }

    override fun onDestroy() {
        movieNPPresenter.onDestroy()
        super.onDestroy()
    }

    companion object {

        val TAG = MovieNPFragment::class.java.simpleName
    }

}