package com.moviereel.ui.movie

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.moviereel.ui.base.BaseViewPagerAdapter
import com.moviereel.ui.movie.nowplaying.MovieNPFragment
import com.moviereel.ui.movie.popular.MoviePopularFrag
import com.moviereel.ui.movie.toprated.MovieTopRatedFrag
import com.moviereel.ui.movie.upcoming.MovieUpcomingFrag

/**
 * @author lusinabrian on 26/08/17.
 * @Notes movie fragment view pager adapter
 */
class MovieFragViewPagerAdapter constructor(fragmentManager: FragmentManager) : BaseViewPagerAdapter(fragmentManager) {

    init {
        fragmentList.add(MovieNPFragment())
        fragmentList.add(MoviePopularFrag())
        fragmentList.add(MovieTopRatedFrag())
        fragmentList.add(MovieUpcomingFrag())
    }

    override fun getItem(position: Int): Fragment {
        return super.getItem(position)
    }
}