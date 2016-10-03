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
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.Language;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.ProductionCompany;
import info.movito.themoviedbapi.model.ProductionCountry;
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
    private static final String MOVIESYNC = MovieSync.class.getSimpleName();
    private SweetAlertDialog progressDialog;
    private List<MovieModel> MovieModelList;
    private Context context;

    private ArrayList<String> movieGenres = new ArrayList<>();
    private ArrayList<String> productionCompanies = new ArrayList<>();
    private ArrayList<String> productionCountries = new ArrayList<>();
    private ArrayList<String> spokenLanguages = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuilder productionCoSb = new StringBuilder();
    private StringBuilder productionCountriesSb = new StringBuilder();
    private StringBuilder spokenLangStrBuilder = new StringBuilder();

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

            //pass an id to the movie to get details about the movie
            MovieDb movie = nowPlaying.getMovie(movieId,"en");

            /*get the genres of the movies*/
            for(Genre genre: movie.getGenres()){
                movieGenres.add(genre.getName());
            }

            for(String s: movieGenres){
                stringBuilder.append(s);
                stringBuilder.append(", ");
            }

            //get production companies
            for(ProductionCompany productionCompany: movie.getProductionCompanies()){
                productionCompanies.add(productionCompany.getName());
            }

            //store the results in a string builder
            for (String s: productionCompanies){
                productionCoSb.append(s);
                productionCoSb.append(", ");
            }

            //get the production countries
            for(ProductionCountry productionCountry: movie.getProductionCountries()){
                productionCountries.add(productionCountry.getName());
            }

            //store the results in a string builder
            for (String s: productionCountries){
                productionCountriesSb.append(s);
                productionCountriesSb.append(", ");
            }

            /**Get spoken languages*/
            for(Language lang: movie.getSpokenLanguages()){
                spokenLanguages.add(lang.getName());
            }

            for(String spokenLang: spokenLanguages){
                spokenLangStrBuilder.append(spokenLang);
                spokenLangStrBuilder.append(", ");
            }

            //todo: fetch video urls and keys
        /*for(Video video:movie.getVideos()){

        }*/

        /*Get images of the movie*/

        /*todo: get reviews if any*/
        /*
        for(Reviews reviews:movie.getReviews()){

        }*/

            int runtime = movie.getRuntime();
            String genres = stringBuilder.toString();
            String tagline = movie.getTagline();
            long revenue = movie.getRevenue();
            String productionCoStr = productionCoSb.toString();
            String productionCountriesStr = productionCountriesSb.toString();
            String homepage = movie.getHomepage();
            boolean isAdult = movie.isAdult();
            long budget = movie.getBudget();
            String imdbid = movie.getImdbID();
            String status = movie.getStatus();
            String languages = spokenLangStrBuilder.toString();

            Log.d(MOVIESYNC+ "Data ", String.valueOf(runtime) +
                    " Genres " + genres +
                    " Tagline" + tagline +
                    " revenue" + String.valueOf(revenue) +
                    " ProductionCompanies: " + productionCoStr +
                    " ProductionCountries " + productionCountriesStr);

            MovieModel movieModel = new MovieModel(poster_path,overview,release_date,new int[]{}, movieId, originalTitle,backdrop_path,moviePopularity,movieVoteCount, movieVoteAvg,runtime, genres,isAdult,budget,homepage,imdbid,revenue,status,tagline,false,productionCountriesStr,productionCoStr,languages);

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