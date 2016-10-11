package com.moviereel.moviereel.tasks;

import android.content.Context;
import android.os.AsyncTask;

import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.models.ReviewsModel;

import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Reviews;

/**
 * MovieReel
 * com.moviereel.moviereel.tasks
 * Created by lusinabrian on 11/10/16.
 * Description: Task to fetch data in the background
 */

public class ReviewFetchTask extends AsyncTask<String, Void, List<ReviewsModel>> {
    private final String FETCHTASK_TAG = ReviewFetchTask.class.getSimpleName();
    private List<Object> objectList;
    private List<ReviewsModel> reviewsModelList;
    private Context context;
    private MovieModel movieModel;

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
        TmdbMovies currentMovie = new TmdbApi(Contract.MOVIE_DB_KEY).getMovies();
        Reviews reviews = currentMovie.getMovie();
        return null;

    }

    @Override
    protected void onPostExecute(List<ReviewsModel> reviewsModels) {
        super.onPostExecute(reviewsModels);
    }

}
