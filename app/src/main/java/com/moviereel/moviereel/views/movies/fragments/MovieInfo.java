package com.moviereel.moviereel.views.movies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moviereel.moviereel.R;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies.fragments
 * Created by lusinabrian on 02/10/16.
 * Description: Fragment to display the movie info
 */

public class MovieInfo extends Fragment {
    public static final String MOVIEINFO_TAG = MovieInfo.class.getSimpleName();

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

        return rootView;
    }
}
