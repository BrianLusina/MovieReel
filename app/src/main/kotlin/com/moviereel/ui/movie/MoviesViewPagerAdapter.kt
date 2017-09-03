package com.moviereel.ui.movie

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.moviereel.ui.movie.nowplaying.MovieNPFragment
import com.moviereel.ui.movie.popular.MoviePopularFrag
import com.moviereel.ui.movie.toprated.MovieTopRatedFrag
import com.moviereel.ui.movie.upcoming.MovieUpcomingFrag

/**
 * @author lusinabrian on 03/09/17.
 * @Notes view pager adapter for movies
 */
class MoviesViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> MovieNPFragment()
            1 -> MoviePopularFrag()
            2 -> MovieTopRatedFrag()
            3 -> MovieUpcomingFrag()
            else -> null
        }
    }

    override fun getCount() = 4
}