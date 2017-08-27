package com.moviereel.ui.movie.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.R

import com.moviereel.ui.base.BaseFragment
import javax.inject.Inject

/**
 * @author lusinabrian on 12/04/17
 */

class MoviePopularFrag : BaseFragment(), MoviePopularView {

    @Inject
    lateinit var moviePopPresenter: MovieTopRatedPresenter<MoviePopularView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_entertainment_page, container,false)

        activityComponent.inject(this)

        moviePopPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    /**
     * Used to setup views in this fragment
     */
    override fun setUp(view: View) {

    }
}
