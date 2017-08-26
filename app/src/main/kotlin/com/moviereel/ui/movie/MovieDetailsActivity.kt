@file:Suppress("DIFFERENT_NAMES_FOR_THE_SAME_PARAMETER_IN_SUPERTYPES")

package com.moviereel.ui.movie

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPager
import com.bumptech.glide.Glide
import com.moviereel.BuildConfig
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.base.BaseActivity
import kotlinx.android.synthetic.main.details_layout.*
import javax.inject.Inject


/**
 * @author lusinabrian on 10/06/17.
 * @Notes Movie details, will display movie details for a clicked item
 */

class MovieDetailsActivity : BaseActivity(), AppBarLayout.OnOffsetChangedListener, MovieDetailsView {

    @Inject
    lateinit var movieDetailsPresenter: MovieDetailsPresenter<MovieDetailsView>

    //@Inject
    lateinit var movieViewPagerAdapter: MovieDetailsViewPagerAdapter

    lateinit var movieObject: MovieNPEntity

    private var mMaxScrollSize: Int = 0
    private var mIsImageHidden: Boolean = false
    private val PERCENTAGE_TO_SHOW_IMAGE = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.details_layout)

        activityComponent?.inject(this)

        movieDetailsPresenter.onAttach(this)

        setUp()
    }

    override fun setUp() {
        // call on back pressed when the navigation menu is clicked
        moviedetail_toolbar.setNavigationOnClickListener({ onBackPressed() })
        moviedetail_appbar_id.addOnOffsetChangedListener(this)

        retrieveItemObject()
        //initializeViewPager()
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, i: Int) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.totalScrollRange

        val currentScrollPercentage = Math.abs(i) * 100 / mMaxScrollSize

        if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
            if (!mIsImageHidden) {
                mIsImageHidden = true

                ViewCompat.animate(moviedetail_fab_share_id).scaleY(0f).scaleX(0f).start()
            }
        }

        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
            if (mIsImageHidden) {
                mIsImageHidden = false
                ViewCompat.animate(moviedetail_fab_share_id).scaleY(1f).scaleX(1f).start()
            }
        }
    }

    /**
     * Retrieves Item object from previous clicked item
     * This will initialize variables that will be passed down to view pager
     * for all fragments to be able to view the data
     * */
    fun retrieveItemObject(): Unit {
        movieObject = intent.extras.getParcelable("MovieObj")

        // TODO: DATA IS NOT VISIBLE HERE, WHY?
        // this is after getting the object from the intent
        moviedetail_collapsingtoolbar.title = movieObject.title
        Glide.with(this)
                .load(BuildConfig.POSTER_PATH + movieObject.posterPath)
                .into(moviedetail_img_id)
    }

    /**
     * Initialize ViewPager
     * */
    fun initializeViewPager(): Unit {
        // set and initialize fragments

        // add arguments to fragments
        moviedetail_viewpager.adapter = movieViewPagerAdapter

        //bind the pager sliding tab strip to the viewpager
        // set the view pager to the tab strip
        moviedetail_navtab_strip.setViewPager(moviedetail_viewpager)

        // page change listener
        moviedetail_navtab_strip.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {

            }

            override fun onPageSelected(i: Int) {
                moviedetail_viewpager.currentItem = i
            }

            override fun onPageScrollStateChanged(i: Int) {

            }
        })
    }
}