package com.moviereel.moviereel.views.movies;

import android.os.AsyncTask;
import android.util.Log;

import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.MovieModel;

import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies
 * Created by lusinabrian on 02/10/16.
 * Description: Sync to get movie details for a particular movie
 */

public class MovieDetSync extends AsyncTask<String, Void, String>  {
    private int movieId;
    private List<MovieModel> movieList;

    public MovieDetSync(){}

    public MovieDetSync(int movieId){
        this.movieId = movieId;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(String... params) {
        //connect to the api with a key and retrieve the movies
        TmdbMovies movieDetails = new TmdbApi(Contract.MOVIE_DB_KEY).getMovies();
        //pass an id to the movie to get details about the movie
        MovieDb movie = movieDetails.getMovie(movieId,"en");

        Log.d("MOVIEDETAILS", String.valueOf(movie.getRuntime()));

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
