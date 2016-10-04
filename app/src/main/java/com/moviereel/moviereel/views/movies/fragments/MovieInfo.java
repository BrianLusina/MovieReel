package com.moviereel.moviereel.views.movies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moviereel.moviereel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies.fragments
 * Created by lusinabrian on 02/10/16.
 * Description: Fragment to display the movie info
 */

public class MovieInfo extends Fragment {
    public static final String MOVIEINFO_TAG = MovieInfo.class.getSimpleName();
    @BindView(R.id.movieinfo_desc_title) TextView movieDescTitle;
    @BindView(R.id.movieinfo_overview_txt) TextView movieOverviewTxt;
    @BindView(R.id.movieinfo_status_field) TextView movieStatusTxt;
    @BindView(R.id.movieinfo_origlang_field) TextView movieOriginalLang;
    @BindView(R.id.movieinfo_budget_field) TextView movieBudget;
    @BindView(R.id.movieinfo_revenue_field) TextView movieRevenue;
    @BindView(R.id.movieinfo_homepage_field) TextView movieHomepage;
    @BindView(R.id.movieinfo_genres_field) TextView movieGenres;


    public MovieInfo(){}

    public static Fragment newInstance(){
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setRetainInstance(true);
        return movieInfo;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movieinfo_layout, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
