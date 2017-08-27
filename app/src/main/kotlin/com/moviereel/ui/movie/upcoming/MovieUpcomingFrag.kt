package com.moviereel.ui.movie.upcoming

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

class MovieUpcomingFrag : BaseFragment(), MovieUpcomingView {

    @Inject
    lateinit var movieUpcomingPresenter: MovieUpcomingPresenter<MovieUpcomingView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_entertainment_page, container,false)

        activityComponent.inject(this)

        movieUpcomingPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    /**
     * Used to setup views in this fragment
     */
    override fun setUp(view: View) {

    }
}
