package com.moviereel.moviereel.views.movies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies.fragments
 * Created by lusinabrian on 02/10/16.
 * Description: The cast of the movie
 */

public class MovieCast extends Fragment {
    public static final String MOVIECAST_TAG = MovieCast.class.getSimpleName();

    public MovieCast(){}

    public static Fragment newInstance(){
        MovieCast movieCast = new MovieCast();
        movieCast.setRetainInstance(true);
        return movieCast;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
