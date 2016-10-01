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
    private OkHttpClient client = new OkHttpClient();
    private Context context;

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
        String url = Contract.NOW_PLAYING;
        try {
            TmdbMovies nowPlaying = new TmdbApi("2f30bdb7e9742c26d4ea364f62f38163").getMovies();

            MovieResultsPage nowPlayingMovies = nowPlaying.getNowPlayingMovies("en",1);
            List<MovieDb> nowPlayingList = nowPlayingMovies.getResults();
            List<Object> someList = new ArrayList<>();
            for(int i = 0; i < nowPlayingList.size();i++){
                someList.add(nowPlayingList.get(i).getPosterPath());
                someList.add(nowPlayingList.get(i).getBackdropPath());
                someList.add(nowPlayingList.get(i).getOverview());
                someList.add(nowPlayingList.get(i).getReleaseDate());
                someList.add(nowPlayingList.get(i).getId());
                someList.add(nowPlayingList.get(i).getOriginalTitle());
                someList.add(nowPlayingList.get(i).getPopularity());
                someList.add(nowPlayingList.get(i).getOriginalTitle());
                someList.add(nowPlayingList.get(i).getVoteAverage());
                someList.add(nowPlayingList.get(i).getVoteCount());
            }

            Log.d(MOVIENOW_PLAYING_TAG+"TMDB", someList.toString());

            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            try {
                    /*PASS the response to the JSONObject*/
                JSONObject jsonObject = new JSONObject(res);
                    /*get the results array from the JSON object*/
                JSONArray result = jsonObject.getJSONArray("results");

                    /*iterate the result array and add the loop through the objects
                    * obtain the JSONObjects storing the relevant data to variables*/
                for(int x = 0; x < result.length(); x++){
                    JSONObject jObject = result.getJSONObject(x);
                    String poster_path = Contract.MOVIE_POSTER_PATH + jObject.getString("poster_path");
                    String backdrop_path = Contract.MOVIE_POSTER_PATH+ jObject.getString("backdrop_path");
                    String overview = jObject.getString("overview");
                    String release_date = jObject.getString("release_date");
                    JSONArray genre_ids = jObject.getJSONArray("genre_ids");
                    int id = jObject.getInt("id");
                    String title =jObject.getString("original_title");
                    double popularity = jObject.getDouble("popularity");
                    int vote_count = jObject.getInt("vote_count");

                    //Store data in shared preferences
                    String data = poster_path + " " + backdrop_path + " " + overview + " " + release_date + " " + genre_ids + " " + String.valueOf(id) + " " + title + " " +  String.valueOf(popularity)+ " " + String.valueOf(vote_count);

                    MovieModel movieModel = new MovieModel(poster_path,overview,release_date,new int[]{}, id, title,backdrop_path,popularity,vote_count);
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
                    editor.putInt("Id", id);
                    editor.putString("Title", title);
                    editor.putInt("Popularity", (int)popularity);
                    editor.putInt("VoteCount", vote_count);

                    //apply these edits
                    editor.apply();
                    Log.d(MOVIENOW_PLAYING_TAG, data);
                    Log.d(MOVIENOW_PLAYING_TAG+"Editor", String.valueOf(editor));
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Log.d(MOVIENOW_PLAYING_TAG, e.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(MOVIENOW_PLAYING_TAG, e.getMessage());
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
