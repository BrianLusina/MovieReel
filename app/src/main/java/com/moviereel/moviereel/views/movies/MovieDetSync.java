package com.moviereel.moviereel.views.movies;

import android.os.AsyncTask;
import android.util.Log;
import android.util.StringBuilderPrinter;

import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Artwork;
import info.movito.themoviedbapi.model.ArtworkType;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.Language;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.ProductionCompany;
import info.movito.themoviedbapi.model.ProductionCountry;
import info.movito.themoviedbapi.model.Reviews;
import info.movito.themoviedbapi.model.Video;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies
 * Created by lusinabrian on 02/10/16.
 * Description: Sync to get movie details for a particular movie
 */

public class MovieDetSync extends AsyncTask<String, Void, String>  {
    public static final String MOVIEDETSYNC_TAG = MovieDetSync.class.getSimpleName();

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
        Log.d(MOVIEDETSYNC_TAG, String.valueOf(movie.getRuntime()) +
                " Genres " + movie.getGenres().toString() +
                " HomePage " + movie.getHomepage() +
                " IMDBID " + movie.getImdbID() +
                " Revenue " + movie.getRevenue() +
                " Status " + movie.getStatus() +
                " tagline " + movie.getTagline() +
                " Cast " + movie.getCast() +
                " Videos " + movie.getVideos() +
                " Images " + movie.getImages() +
                " Reviews " + movie.getReviews());

        ArrayList<String> movieGenres = new ArrayList<>();
        ArrayList<String> productionCompanies = new ArrayList<>();
        ArrayList<String> productionCountries = new ArrayList<>();
        ArrayList<String> spokenLanguages = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder productionCoSb = new StringBuilder();
        StringBuilder productionCountriesSb = new StringBuilder();
        StringBuilder spokenLangStrBuilder = new StringBuilder();

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

        Log.d(MOVIEDETSYNC_TAG+ "Data ", String.valueOf(runtime) +
                " Genres " + genres +
                " Tagline" + tagline +
                " revenue" + String.valueOf(revenue) +
                " ProductionCompanies: " + productionCoStr +
                " ProductionCountries " + productionCountriesStr);

        //TODO: change if has video boolean
        MovieModel movieModel = new MovieModel(runtime, genres,isAdult,budget,homepage,imdbid,revenue,status,tagline,false,productionCountriesStr,productionCoStr,languages);

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
