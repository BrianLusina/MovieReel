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

public class MovieMedia extends Fragment {
    public static final String MOVIEMEDIA_TAG = MovieMedia.class.getSimpleName();

    public MovieMedia(){}

    public static Fragment newInstance(){
        MovieMedia movieMedia = new MovieMedia();
        movieMedia.setRetainInstance(true);
        return movieMedia;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.moviemedia_layout, container, false);

        return rootView;
    }
}
