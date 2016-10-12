package com.moviereel.moviereel.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.moviereel.moviereel.R;
import com.moviereel.moviereel.adapter.MovieCastAdapter;
import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.models.ReviewsModel;

import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbReviews;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Reviews;

/**
 * MovieReel
 * com.moviereel.moviereel.tasks
 * Created by lusinabrian on 11/10/16.
 * Description: Task to fetch data in the background
 */

public class ReviewFetchTask extends AsyncTask<String, Void, List<ReviewsModel>> {
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

    }

}
