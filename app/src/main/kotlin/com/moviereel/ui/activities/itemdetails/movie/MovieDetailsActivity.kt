@file:Suppress("DIFFERENT_NAMES_FOR_THE_SAME_PARAMETER_IN_SUPERTYPES")

package com.moviereel.ui.activities.itemdetails.movie

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import com.moviereel.R
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import butterknife.ButterKnife
import javax.inject.Inject
import android.support.v4.view.ViewCompat
import android.util.Log
import com.gigamole.navigationtabstrip.NavigationTabStrip
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.moviereel.BuildConfig
import com.moviereel.data.api.model.movie.response.MovieResultsResponse
import com.moviereel.ui.base.BaseActivity


/**
 * @author lusinabrian on 10/06/17.
 * @Notes Movie details, will display movie details for a clicked item
 */

class MovieDetailsActivity : BaseActivity(), AppBarLayout.OnOffsetChangedListener, MovieDetailsView{

    /*UI Views*/
    lateinit var mFab: View
    lateinit var toolbar: Toolbar
    lateinit var movieDetailImg: ImageView
    lateinit var mNavigationTabStrip: NavigationTabStrip
    lateinit var mViewPager: ViewPager
    lateinit var appbar: AppBarLayout
    lateinit var mCollapseToolbar: CollapsingToolbarLayout

    @Inject
    lateinit var movieDetailsPresenter : MovieDetailsPresenter<MovieDetailsView>

    @Inject
    lateinit var movieViewPagerAdapter : MovieDetailsViewPagerAdapter

    lateinit var movieObject : MovieResultsResponse
    lateinit var bundle: Bundle

    private var mMaxScrollSize: Int = 0
    private var mIsImageHidden: Boolean = false
    private val PERCENTAGE_TO_SHOW_IMAGE = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.movie_details_layout)

        activityComponent?.inject(this)

        setUnbinder(ButterKnife.bind(this))

        movieDetailsPresenter.onAttach(this)
        
        setUp()
    }

    override fun setUp() {
        mFab = findViewById(R.id.moviedetail_fab_share_id) as View
        toolbar = findViewById(R.id.moviedetail_toolbar) as Toolbar 
        movieDetailImg = findViewById(R.id.moviedetail_img_id) as ImageView
        mNavigationTabStrip = findViewById(R.id.moviedetail_navtab_strip) as NavigationTabStrip

        mViewPager = findViewById(R.id.moviedetail_viewpager) as ViewPager
        appbar = findViewById(R.id.moviedetail_appbar_id) as AppBarLayout
        mCollapseToolbar = findViewById(R.id.moviedetail_collapsingtoolbar) as CollapsingToolbarLayout

        // call on back pressed when the navigation menu is clicked
        toolbar.setNavigationOnClickListener({ onBackPressed() })
        appbar.addOnOffsetChangedListener(this)

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

                ViewCompat.animate(mFab).scaleY(0f).scaleX(0f).start()
            }
        }

        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
            if (mIsImageHidden) {
                mIsImageHidden = false
                ViewCompat.animate(mFab).scaleY(1f).scaleX(1f).start()
            }
        }
    }

    /**
     * Retrieves Item object from previous clicked item
     * This will initialize variables that will be passed down to view pager
     * for all fragments to be able to view the data
     * */
    fun retrieveItemObject() : Unit{
        movieObject = intent.extras.getParcelable("MovieObj")
        bundle = Bundle()
        bundle.putParcelable("MovieObjData", movieObject)

        // TODO: DATA IS NOT VISIBLE HERE, WHY?
        // this is after getting the object from the intent
        mCollapseToolbar.title = movieObject.title
        Glide.with(this)
                .load(BuildConfig.POSTER_PATH + movieObject.posterPath)
                .into(movieDetailImg)
    }

    /**
     * Initialize ViewPager
     * */
    fun initializeViewPager() : Unit{
        // set and initialize fragments

        // add arguments to fragments
        mViewPager.adapter = movieViewPagerAdapter

        //bind the pager sliding tab strip to the viewpager
        // set the view pager to the tab strip
        mNavigationTabStrip.setViewPager(mViewPager)

        // page change listener
        mNavigationTabStrip.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {

            }

            override fun onPageSelected(i: Int) {
                mViewPager.currentItem = i
            }

            override fun onPageScrollStateChanged(i: Int) {

            }
        })
    }
}