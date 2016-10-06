package com.moviereel.moviereel.views.movies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.adapter.MovieCastAdapter;
import com.moviereel.moviereel.models.ActorModel;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.tasks.MovieCastTask;
import com.moviereel.moviereel.utils.IsNetwork;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.moviereel.moviereel.models.Contract.MOVIE_PARCEL_KEY;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies.fragments
 * Created by lusinabrian on 02/10/16.
 * Description: The cast of the movie*/

public class MovieCast extends Fragment {
    public static final String MOVIECAST_TAG = MovieCast.class.getSimpleName();
    @BindView(R.id.moviecast_recyclerView) RecyclerView movieCastRecycler;
    private MovieModel movieModel;
    private List<ActorModel> actorModelList;
    private MovieCastAdapter movieCastAdapter;
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

        // fetch the cast
        MovieCastTask fetchCastTask = new MovieCastTask(getActivity(),actorModelList,movieModel);
        actorModelList = new ArrayList<>();

        // initialize the MovieCastAdapter
        movieCastAdapter = new MovieCastAdapter(getActivity(), actorModelList, R.layout.moviecast_item_layout);

        //check for internet connection
        if(IsNetwork.isNetworkAvailable(getActivity())) {
            fetchCastTask.execute();
        }else{
            //display tasty toast of no network connection
            TastyToast.makeText(getActivity(),getResources().getString(R.string.snackbar_warning_no_internet_conn), TastyToast.LENGTH_SHORT,TastyToast.ERROR);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.moviecast_layout, container, false);

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(),2);
        mGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        movieCastRecycler.setHasFixedSize(true);
        movieCastRecycler.setLayoutManager(mGridLayoutManager);
        movieCastRecycler.setAdapter(movieCastAdapter);
        return rootView;
    }


}
