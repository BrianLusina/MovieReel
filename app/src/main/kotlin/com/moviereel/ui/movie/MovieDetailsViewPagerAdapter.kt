package com.moviereel.ui.movie

import android.support.v4.app.FragmentManager
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.base.BaseViewPagerAdapter

/**
 * @author lusinabrian on 10/06/17.
 * @Notes Movie details view pager adapter
 */
class MovieDetailsViewPagerAdapter
//@Inject
constructor(
        fragmentManager: FragmentManager,
        itemObject: MovieNPEntity) : BaseViewPagerAdapter(fragmentManager, itemObject)