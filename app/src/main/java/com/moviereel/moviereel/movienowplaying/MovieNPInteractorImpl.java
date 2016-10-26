package com.moviereel.moviereel.movienowplaying;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.MovieModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.pedant.SweetAlert.SweetAlertDialog;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.Language;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.ProductionCompany;
import info.movito.themoviedbapi.model.ProductionCountry;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

import static com.moviereel.moviereel.utils.Constants.MOVIE_NP_PREF;

/**
 * MovieReel
 * com.moviereel.moviereel.movienowplaying
 * Created by lusinabrian on 26/10/16.
 * Description: Implementation of {@link MovieNPInteractor}
 */

class MovieNPInteractorImpl implements MovieNPInteractor {
    private static final String MOVIESYNC = MovieSync.class.getSimpleName();

    @Override
    public void findItems(Context context, OnFinishedListener listener) {
        MovieSync movieSync = new MovieSync(context,listener);
        movieSync.execute();
    }

    private class MovieSync extends AsyncTask<String, Void, List<MovieModel>> {
        private List<MovieModel> movieModelList;
        private OnFinishedListener listener;
        private Context context;

        MovieSync(Context context, OnFinishedListener listener) {
            this.listener = listener;
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<MovieModel> doInBackground(String... params) {
            TmdbMovies nowPlaying = new TmdbApi(Contract.MOVIE_DB_KEY).getMovies();
            MovieResultsPage nowPlayingMovies = nowPlaying.getNowPlayingMovies("en", 1);
            List<MovieDb> nowPlayingList = nowPlayingMovies.getResults();
            movieModelList = new ArrayList<>();

            Gson gson = new Gson();

            /*create a shared preference file for each movie by id*/
            SharedPreferences mMovie = context.getSharedPreferences(MOVIE_NP_PREF, 0);

            for (int i = 0; i < nowPlayingList.size(); i++) {
                Set<String> movieGenresSet = new HashSet<>();
                ArrayList<String> movieGenresArrLst = new ArrayList<>();
                ArrayList<String> productionCompanies = new ArrayList<>();
                ArrayList<String> productionCountries = new ArrayList<>();
                ArrayList<String> spokenLanguages = new ArrayList<>();
                StringBuilder genresStringBuilder = new StringBuilder();
                StringBuilder productionCoSb = new StringBuilder();
                StringBuilder productionCountriesSb = new StringBuilder();
                StringBuilder spokenLangStrBuilder = new StringBuilder();

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
                MovieDb movie = nowPlaying.getMovie(movieId, "en");

            /*get the genres of the movies*/
                for (Genre genre : movie.getGenres()) {
                    movieGenresArrLst.add(genre.getName());
                }

            /*Add the whole arraylist to a hash set to remove all duplicates from the Genres list
            * clear the array list and add the hash set back to the arraylist*/
                movieGenresSet.addAll(movieGenresArrLst);
                movieGenresArrLst.clear();
                movieGenresArrLst.addAll(movieGenresSet);

                for (String s : movieGenresSet) {
                    genresStringBuilder.append(s);
                    genresStringBuilder.append(", ");
                }

                //get production companies
                for (ProductionCompany productionCompany : movie.getProductionCompanies()) {
                    productionCompanies.add(productionCompany.getName());
                }

                //store the results in a string builder
                for (String s : productionCompanies) {
                    productionCoSb.append(s);
                    productionCoSb.append(", ");
                }

                //get the production countries
                for (ProductionCountry productionCountry : movie.getProductionCountries()) {
                    productionCountries.add(productionCountry.getName());
                }

                //store the results in a string builder
                for (String s : productionCountries) {
                    productionCountriesSb.append(s);
                    productionCountriesSb.append(", ");
                }

                /**Get spoken languages*/
                for (Language lang : movie.getSpokenLanguages()) {
                    spokenLanguages.add(lang.getName());
                }

                for (String spokenLang : spokenLanguages) {
                    spokenLangStrBuilder.append(spokenLang);
                    spokenLangStrBuilder.append(", ");
                }

                int runtime = movie.getRuntime();
                String genres = genresStringBuilder.toString();
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

                MovieModel movieModel = new MovieModel(poster_path, overview, release_date, new int[]{}, movieId, originalTitle, backdrop_path, moviePopularity, movieVoteCount, movieVoteAvg, runtime, genres, isAdult, budget, homepage, imdbid, revenue, status, tagline, false, productionCountriesStr, productionCoStr, languages);

                SharedPreferences.Editor editor = mMovie.edit();
                String movieJson = gson.toJson(movieModel);
            /*append the movie id as a key to allow retrieval of this movie details*/
                editor.putString("MovieNowPlayingObj" + String.valueOf(movieId), movieJson);

                editor.apply();

            /* to retrieve
            Gson gson = new Gson();
            String json = mPrefs.getString("MovieNowPlayingObj"+String.valueOf(movieId), "");
            MovieModel obj = gson.fromJson(json, MovieModel.class);*/

                movieModelList.add(movieModel);

                Log.d(MOVIESYNC + "DATA ", movieModel.toString());
            }

            return movieModelList;
        }

        @Override
        protected void onPostExecute(List<MovieModel> movieModelList) {
            super.onPostExecute(movieModelList);
            listener.onFinished(movieModelList);
        }
    }

}
