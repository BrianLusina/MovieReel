package com.moviereel.ui.entertain.movie

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.presentation.view.entertain.movie.MovieFragView
import com.moviereel.presentation.view.entertain.movie.MoviesPresenter
import com.moviereel.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_section_layout.view.*
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * @author lusinabrian on 26/08/17.
 * @Notes Movies fragment, this view will contain the view pager that will be used to display
 * now playing movies, popular movies, etc
 */
class MoviesFragment : BaseFragment(), MovieFragView {

    companion object {
        const val TAG = "MOVIE_FRAGMENT"
    }

    @Inject
    lateinit var moviesPresenter: MoviesPresenter<MovieFragView>

    @Inject
    lateinit var movieViewPagerAdapter : MoviesViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate(R.layout.fragment_section_layout, container, false)

        moviesPresenter.onAttach(this)

        setUpView(rootView)

        return rootView
    }

    private fun setUpView(view: View){
        with(view) {
            view_pager.adapter = movieViewPagerAdapter

            navigation_tab_strip.setViewPager(view_pager)
            navigation_tab_strip.setTitles(
                    R.string.movie_now_playing_title,
                    R.string.movie_popular_title,
                    R.string.movie_top_rated_title,
                    R.string.movie_upcoming_title
            )

            navigation_tab_strip.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {}

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

                override fun onPageSelected(position: Int) {
                    view_pager.currentItem = position
                }
            })
        }
    }
}