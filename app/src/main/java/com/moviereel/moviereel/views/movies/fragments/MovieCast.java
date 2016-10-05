package com.moviereel.moviereel.views.movies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moviereel.moviereel.R;
import com.moviereel.moviereel.models.MovieModel;

import butterknife.BindView;

import static com.moviereel.moviereel.models.Contract.MOVIE_PARCEL_KEY;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies.fragments
 * Created by lusinabrian on 02/10/16.
 * Description: The cast of the movie
 */

public class MovieCast extends Fragment {
    public static final String MOVIECAST_TAG = MovieCast.class.getSimpleName();
    @BindView(R.id.moviecast_recyclerView) RecyclerView movieCastRecycler;
    private MovieModel movieModel;
    private Bundle bundle;

    public MovieCast(){}

    public static Fragment newInstance(){
        MovieCast movieCast = new MovieCast();
        movieCast.setRetainInstance(true);
        return movieCast;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrieve the arguments and set them to the movie model
        bundle = getArguments();
        movieModel = bundle.getParcelable(MOVIE_PARCEL_KEY);
        Log.d(MOVIECAST_TAG+"BundleReceived:", movieModel != null ? movieModel.getMovie_title() : null);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.moviecast_layout, container, false);

        return rootView;
    }
}
