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
 * Description:
 */

public class MovieImages extends Fragment {
    public static final String MOVIEIMAGES_TAG = MovieImages.class.getSimpleName();

    public MovieImages(){}

    public static Fragment newInstance(){
        MovieImages movieImages = new MovieImages();
        movieImages.setRetainInstance(true);
        return movieImages;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movieimages_layout, container, false);

        return rootView;
    }
}
