package com.moviereel.ui.movie.nowplaying

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.base.BaseFragment

import javax.inject.Inject

import com.moviereel.data.api.model.BaseResultsResponse
import kotlinx.android.synthetic.main.fragment_movie_layout.view.*
import org.jetbrains.anko.toast

class MovieNPFragment : BaseFragment(), MovieNPView {

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

        with(view){
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
            // frag_movie_coordinator_layout
        }

        // mRecyclerView.setAdapter(movieNPAdapter);
        movieNPPresenter.onViewInitialized()
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
        activity.toast(message)
    }

    override fun startActivityForClickedItem(bundleKey: String, movieList: List<MovieNPEntity>) {
//        mRecyclerView.addOnItemTouchListener(RecyclerItemClickListener(activity,
//                RecyclerItemClickListener.OnItemClickListener { view, position ->
//                    //Intent showMovieDet = new Intent(getActivity(),MovieDetails.class);
//                    // TODO: 10/05/17 bundle
//                    //showMovieDet.putExtra(bundleKey, movieList.get(position));
//                    //startActivity(showMovieDet);
//                }))
    }

    override fun onRecyclerItemClicked(bundleKey: String, movieList: List<MovieNPEntity>) {
        movieNPPresenter.onItemClicked(bundleKey, movieList)
    }

    override fun updateMoviesNowPlaying(movieResultsResponseList: ArrayList<MovieNPEntity>) {
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