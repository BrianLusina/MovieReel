package com.moviereel.ui.entertain.movie

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.moviereel.ui.entertain.movie.nowplaying.NowPlayingFragment
import com.moviereel.ui.entertain.movie.popular.MoviePopularFrag
import com.moviereel.ui.entertain.movie.upcoming.MovieUpcomingFrag

/**
 * @author lusinabrian on 03/09/17.
 * @Notes view pager adapter for movies
 */
class MoviesViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> NowPlayingFragment()
            1 -> MoviePopularFrag()
            // 2 -> MovieTopRatedFrag()
            3 -> MovieUpcomingFrag()
            else -> null
        }
    }

    override fun getCount() = 4
}