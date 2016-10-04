package com.moviereel.moviereel.views.movies;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;
import com.bumptech.glide.Glide;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.adapter.ViewPagerAdapter;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.views.movies.fragments.MovieCast;
import com.moviereel.moviereel.views.movies.fragments.MovieImages;
import com.moviereel.moviereel.views.movies.fragments.MovieInfo;
import com.moviereel.moviereel.views.movies.fragments.MovieMedia;
import com.moviereel.moviereel.views.movies.fragments.MovieReviews;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 09:58
 * Description: Display of movie details using flexible space
 */
public class MovieDetails extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    public static final String MOVIEDETAIL_TAG = MovieDetails.class.getSimpleName();
    private MovieModel movieObj;
    private Bundle bundle;
    /*UI Views*/
    @BindView(R.id.moviedetail_fab_share_id) View mFab;
    @BindView(R.id.moviedetail_toolbar) Toolbar toolbar;
    @BindView(R.id.moviedetail_img_id) ImageView movieDetailImg;
    @BindView(R.id.moviedetail_pagerslidingtabs) PagerSlidingTabStrip pagerSlidingTabStrip;
    @BindView(R.id.moviedetail_viewpager) ViewPager mViewPager;
    @BindView(R.id.moviedetail_appbar_id) AppBarLayout appbar;
    @BindView(R.id.moviedetail_collapsingtoolbar) CollapsingToolbarLayout mCollapseToolbar;


    private int mMaxScrollSize;
    private boolean mIsImageHidden;
    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details_layout);
        ButterKnife.bind(this);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        appbar.addOnOffsetChangedListener(this);
        retrieveObj();
        initViewPager();
    }

    /*Retrieves the object from previous Activity*/
    private void retrieveObj() {
        movieObj = getIntent().getExtras().getParcelable("MovieObj");
        bundle = new Bundle();
        bundle.putParcelable("MOVIE_DATA", movieObj);
        Log.d(MOVIEDETAIL_TAG+"Bundle",bundle.toString());

        if (movieObj != null) {
            mCollapseToolbar.setTitle(movieObj.getMovie_title());
            Glide.with(this)
                    .load(movieObj.getMovie_poster_url())
                    .into(movieDetailImg);
        }else{
            //TODO: display error to user in such an event
            Log.d(MOVIEDETAIL_TAG, "No Data Received");
        }
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int currentScrollPercentage = (Math.abs(i)) * 100 / mMaxScrollSize;

        if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
            if (!mIsImageHidden) {
                mIsImageHidden = true;

                ViewCompat.animate(mFab).scaleY(0).scaleX(0).start();
            }
        }

        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
            if (mIsImageHidden) {
                mIsImageHidden = false;
                ViewCompat.animate(mFab).scaleY(1).scaleX(1).start();
            }
        }
    }

    /**Initialize the ViewPager and set the adapter*/
    private void initViewPager() {
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), movieObj);
        /*Pass the bundle to the fragments and set the bundle*/
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setArguments(bundle);

        mViewPagerAdapter.addFragment(movieInfo, "Info");

        mViewPagerAdapter.addFragment(MovieCast.newInstance(), "Cast");
        mViewPagerAdapter.addFragment(MovieImages.newInstance(), "Images");
        mViewPagerAdapter.addFragment(MovieReviews.newInstance(), "Reviews");
        mViewPagerAdapter.addFragment(MovieMedia.newInstance(), "Media");
        mViewPager.setAdapter(mViewPagerAdapter);

        //bind the pager sliding tab strip to the viewpager
        pagerSlidingTabStrip.setViewPager(mViewPager);
        pagerSlidingTabStrip.setTextColor(R.color.light_red3);
        pagerSlidingTabStrip.setTextColorResource(R.color.light_red3);
        pagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
