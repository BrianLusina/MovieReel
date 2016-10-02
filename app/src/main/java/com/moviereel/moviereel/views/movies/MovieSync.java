package com.moviereel.moviereel.views.movies;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.moviereel.moviereel.R;
import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import static com.moviereel.moviereel.views.movies.MovieNowPlaying.MOVIENOW_PLAYING_TAG;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies
 * Created by lusinabrian on 01/10/16.
 * Description: Sync Task to fetch movies*/

public class MovieSync extends AsyncTask<String, Void, String> {
    private SweetAlertDialog progressDialog;
    private List<MovieModel> MovieModelList;
    private Context context;
    private MovieDetSync movieDetSync;

    public MovieSync(){}

    public MovieSync(Context context, List<MovieModel> MovieModelList){
        this.context = context;
        this.MovieModelList = MovieModelList;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        progressDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.cadet_blue));
        progressDialog.setTitleText("Hold on");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        TmdbMovies nowPlaying = new TmdbApi(Contract.MOVIE_DB_KEY).getMovies();

        MovieResultsPage nowPlayingMovies = nowPlaying.getNowPlayingMovies("en",1);
        List<MovieDb> nowPlayingList = nowPlayingMovies.getResults();
        for(int i = 0; i < nowPlayingList.size();i++){
        /*Retrieve the data and store it relevant variables*/
            String poster_path = Contract.MOVIE_POSTER_PATH + nowPlayingList.get(i).getPosterPath();
            String backdrop_path = Contract.MOVIE_POSTER_PATH + nowPlayingList.get(i).getBackdropPath();
            String overview = nowPlayingList.get(i).getOverview();
            String release_date = nowPlayingList.get(i).getReleaseDate();
            int movieId = nowPlayingList.get(i).getId();
            String originalTitle = nowPlayingList.get(i).getOriginalTitle();
            float moviePopularity = nowPlayingList.get(i).getPopularity();
            float movieVoteAvg = nowPlayingList.get(i).getVoteAverage();
            int movieVoteCount = nowPlayingList.get(i).getVoteCount();

            //pass the id of the movie to another thread to fetch more details about the movie
            movieDetSync = new MovieDetSync(movieId);
            movieDetSync.doInBackground();

            MovieModel movieModel = new MovieModel(poster_path,overview,release_date,new int[]{}, movieId, originalTitle,backdrop_path,moviePopularity,movieVoteCount, movieVoteAvg);
            MovieModelList.add(movieModel);


            /**Get an instance of the shared preferences create and access the MovieData
             * Store the data only to the application*/
            SharedPreferences movieData = context.getSharedPreferences("MovieData",0);

            //create an editor
            SharedPreferences.Editor editor = movieData.edit();

            //add data to it
            editor.putString("PosterPath", poster_path);
            editor.putString("BackdropPath", backdrop_path);
            editor.putString("Overview", overview);
            editor.putString("ReleaseDate", release_date);
            editor.putInt("Id", movieId);
            editor.putString("Title", originalTitle);
            editor.putFloat("Popularity", (int)moviePopularity);
            editor.putInt("VoteCount", movieVoteCount);

            //apply these edits
            editor.apply();
            Log.d(MOVIENOW_PLAYING_TAG+"Editor", String.valueOf(editor));
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }
}