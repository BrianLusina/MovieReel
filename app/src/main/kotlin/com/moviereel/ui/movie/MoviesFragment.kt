package com.moviereel.ui.movie

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movie_layout.view.*
import javax.inject.Inject

/**
 * @author lusinabrian on 26/08/17.
 * @Notes Movies fragment, this view will contain the view pager that will be used to display
 * now playing movies, popular movies, etc
 */
class MoviesFragment : BaseFragment(), MovieFragView {

    @Inject
    lateinit var movieFragPresenter: MovieFragPresenter<MovieFragView>

    lateinit var moviePagerAdapter: MovieFragViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_movie_layout, container, false)

        activityComponent.inject(this)

        movieFragPresenter.onAttach(this)

        setUp(rootView)

        return rootView
    }

    override fun setUp(view: View) {
        moviePagerAdapter = MovieFragViewPagerAdapter(activity.supportFragmentManager)
        with(view) {
            movieFragViewPager.adapter = moviePagerAdapter
            movieFragNavTabStrip.setViewPager(movieFragViewPager)

            movieFragNavTabStrip.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {}

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

                override fun onPageSelected(position: Int) {
                    movieFragViewPager.currentItem = position
                    movieFragNavTabStrip.activeColor
                }
            })
        }
    }
}