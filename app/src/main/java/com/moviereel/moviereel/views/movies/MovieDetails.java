package com.moviereel.moviereel.views.movies;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;
import com.moviereel.moviereel.R;

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
    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    @BindView(R.id.moviedetail_fab_share_id) View mFab;
    @BindView(R.id.moviedetail_toolbar) Toolbar toolbar;
    @BindView(R.id.moviedetail_img_id) ImageView movieDetailImg;
    @BindView(R.id.moviedetail_pagerslidingtabs) PagerSlidingTabStrip pagerSlidingTabStrip;
    @BindView(R.id.moviedetail_viewpager) ViewPager viewPager;
    @BindView(R.id.moviedetail_appbar_id) AppBarLayout appbar;
    private int mMaxScrollSize;
    private boolean mIsImageHidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details_layout);
        ButterKnife.bind(this);

        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        appbar.addOnOffsetChangedListener(this);
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
}
