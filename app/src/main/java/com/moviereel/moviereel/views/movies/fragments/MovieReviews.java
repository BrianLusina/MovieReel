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
import com.moviereel.moviereel.adapter.MovieCastAdapter;
import com.moviereel.moviereel.adapter.MovieReviewAdapter;
import com.moviereel.moviereel.models.ActorModel;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.models.ReviewsModel;
import com.moviereel.moviereel.tasks.FetchTask;
import com.moviereel.moviereel.utils.IsNetwork;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.moviereel.moviereel.models.Contract.MOVIE_PARCEL_KEY;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies.fragments
 * Created by lusinabrian on 02/10/16.
 * Description:
 */
public class MovieReviews extends Fragment{
    public static final String MOVIEREVIEWS_TAG = MovieReviews.class.getSimpleName();
    @BindView(R.id.moviereview_recyclerView) RecyclerView reviewRecycler;
    private MovieReviewAdapter movieReviewAdapter;

    public MovieReviews(){}

    public static Fragment newInstance(){
        MovieReviews movieReviews = new MovieReviews();
        movieReviews.setRetainInstance(true);
        return movieReviews;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrieve the arguments and set them to the movie model
        Bundle bundle = getArguments();
        MovieModel movieModel = bundle.getParcelable(MOVIE_PARCEL_KEY);

        Log.d(MOVIEREVIEWS_TAG+"BundleReceived:", movieModel != null ? movieModel.getMovie_title() : null);

        // fetch the cast
        List<ReviewsModel> reviewsModelList = new ArrayList<>();
        FetchTask fetchTask = new FetchTask(getActivity(), reviewsModelList, movieModel);

        //check for internet connection
        if(IsNetwork.isNetworkAvailable(getActivity())) {
            fetchTask.execute();
        }else{
            //display tasty toast of no network connection
            TastyToast.makeText(getActivity(),getResources().getString(R.string.snackbar_warning_no_internet_conn), TastyToast.LENGTH_SHORT,TastyToast.ERROR);
        }

        movieReviewAdapter = new MovieReviewAdapter(getActivity(), reviewsModelList, R.layout.moviecast_item_layout);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.moviereviews_layout, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
    }


}
