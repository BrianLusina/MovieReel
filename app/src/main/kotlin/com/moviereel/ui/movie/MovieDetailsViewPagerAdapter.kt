package com.moviereel.ui.movie

import android.support.v4.app.FragmentManager
import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.ui.base.BaseViewPagerAdapter
import javax.inject.Inject

/**
 * @author lusinabrian on 10/06/17.
 * @Notes Movie details view pager adapter
 */
class MovieDetailsViewPagerAdapter @Inject constructor(fragmentManager: FragmentManager, itemObject: BaseResultsResponse.MovieResultsResponse) : BaseViewPagerAdapter(fragmentManager, itemObject)