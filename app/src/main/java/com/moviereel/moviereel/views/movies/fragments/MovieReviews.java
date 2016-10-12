package com.moviereel.moviereel.views.movies.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moviereel.moviereel.R;
import com.moviereel.moviereel.adapter.MovieReviewAdapter;
import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.models.ReviewsModel;
import com.moviereel.moviereel.utils.IsNetwork;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbReviews;
import info.movito.themoviedbapi.model.Reviews;

import static com.moviereel.moviereel.models.Contract.MOVIE_PARCEL_KEY;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies.fragments
 * Created by lusinabrian on 02/10/16.
 * Description: Displays the reviews for the current movie
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
        ReviewFetchTask reviewFetchTask = new ReviewFetchTask(getActivity(), reviewsModelList, movieModel);

        //check for internet connection
        if(IsNetwork.isNetworkAvailable(getActivity())) {
            reviewFetchTask.execute();
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

        /*set the adapter*/
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reviewRecycler.setHasFixedSize(true);
        reviewRecycler.setLayoutManager(mLinearLayoutManager);
        reviewRecycler.setAdapter(movieReviewAdapter);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        reviewRecycler.setAdapter(movieReviewAdapter);
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
/*-**-*-*-*-*-*-*-*-*-*--**********************-------------------*-*-*-*-*-*--*-*-*/
private class ReviewFetchTask extends AsyncTask<String, Void, List<ReviewsModel>> {
    private final String REVIEWFETCHTASK_TAG = ReviewFetchTask.class.getSimpleName();
    private List<ReviewsModel> reviewsModelList;
    private Context context;
    private MovieModel movieModel;
    private ReviewsModel reviewsModel;

    public ReviewFetchTask(){}

    public ReviewFetchTask(Context context, List<ReviewsModel> reviewsModelList, MovieModel movieModel){
        this.context = context;
        this.reviewsModelList = reviewsModelList;
        this.movieModel = movieModel;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<ReviewsModel> doInBackground(String... params) {
        //pass an id to the movie to get details about the movie
        TmdbReviews currentMovie = new TmdbApi(Contract.MOVIE_DB_KEY).getReviews();
        TmdbReviews.ReviewResultsPage thisMovie = currentMovie.getReviews(movieModel.getMovie_id(), "en",1);
        String author, content, url, id;

        /**for each review in the list, extract the data and store in variables*/
        for(Reviews reviews : thisMovie.getResults()){
            author = reviews.getAuthor();
            content = reviews.getContent();
            url = reviews.getUrl();
            id = reviews.getId();
            reviewsModel = new ReviewsModel(id, author,content,url);
            reviewsModelList.add(reviewsModel);
        }
        /*log the data for debugging*/
        Log.d(REVIEWFETCHTASK_TAG, reviewsModelList.toString());
        return reviewsModelList;
    }

    @Override
    protected void onPostExecute(List<ReviewsModel> reviewsModels) {
        super.onPostExecute(reviewsModels);
        movieReviewAdapter = new MovieReviewAdapter(getActivity(), reviewsModelList, R.layout.moviecast_item_layout);
    }
}

}
