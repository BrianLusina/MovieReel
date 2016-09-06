package com.moviereel.moviereel.views;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moviereel.moviereel.Contracts.ApiContract;
import com.moviereel.moviereel.singletons.IsNetwork;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.adapter.MovieAdapter;
import com.moviereel.moviereel.models.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 22/08/16 at 19:08
 * Description: Main screen of the application, will feature the latest movies, will use Movie details layout as it is the only movie showing
 */
public class HomeFragment extends Fragment{

    public static final String HOMEFRAG_TAG = HomeFragment.class.getSimpleName();
    private MovieAdapter movieAdapter;
    private List<MovieModel> movieList;
    private CoordinatorLayout coordinatorLayout;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private ImageView movie_poster;
    private TextView movie_title;
    private TextView movie_overview;
    private IsNetwork isNetwork = new IsNetwork();

    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    private View mShareFab;
    private int mMaxScrollSize;
    private boolean mIsImageHidden;

    private int id,popularity, vote_count, runtime, revenue, budget;

    private String title = " ";
    private String overview = " ";
    private String backdrop_path = " ";
    private String poster_path = " ";
    private String tagline = " ";
    private String status = " ";
    private String original_language = " ";
    private String release_date = " ";

    boolean is_adult;
    JSONArray genres;

    /*empty constructor*/
    public HomeFragment(){}

    public static Fragment newInstance(){
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setRetainInstance(true);
        return  homeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadMovie loadMovies = new LoadMovie();
        if(isNetwork.isNetworkAvailable(getActivity())) {
            loadMovies.execute();
            //private ImageView movie_poster;
            movie_title.setText(title);
            movie_overview.setText(overview);
            //TODO: change fallback image
            if(poster_path != null){
                Glide.with(getActivity())
                        .load(ApiContract.MOVIE_POSTER_PATH+poster_path)
                        .centerCrop()
                        .fitCenter()
                        .fallback(R.mipmap.ic_launcher)
                        .crossFade()
                        .into(movie_poster);
            }
        }else{
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, getString(R.string.snackbar_warning_no_internet_conn), Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.snackbar_no_internet_conn_retry), new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(coordinatorLayout, getString(R.string.snackbar_no_internet_conn_retry), Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movie_details_layout, container, false);
        mShareFab = rootView.findViewById(R.id.moviedetail_fab_share_id);
        movie_poster = (ImageView) rootView.findViewById(R.id.movie_detail_img_id);
        movie_title = (TextView) rootView.findViewById(R.id.movie_detail_title_id);
        movie_overview = (TextView)rootView.findViewById(R.id.movie_detail_overview_id);

        AppBarLayout appbar = (AppBarLayout) rootView.findViewById(R.id.moviedetail_appbar_id);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (mMaxScrollSize == 0)
                    mMaxScrollSize = appBarLayout.getTotalScrollRange();

                int currentScrollPercentage = (Math.abs(verticalOffset)) * 100
                        / mMaxScrollSize;

                if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
                    if (!mIsImageHidden) {
                        mIsImageHidden = true;

                        ViewCompat.animate(mShareFab).scaleY(0).scaleX(0).start();
                    }
                }

                if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
                    if (mIsImageHidden) {
                        mIsImageHidden = false;
                        ViewCompat.animate(mShareFab).scaleY(1).scaleX(1).start();
                    }
                }
            }
        });
        return rootView;
    }

    private class LoadMovie extends AsyncTask<String, Void, String>{
        SweetAlertDialog progressDialog = new SweetAlertDialog(getContext(), SweetAlertDialog.PROGRESS_TYPE);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.cadet_blue));
            progressDialog.setTitleText(getResources().getString(R.string.get_latest_movie));
            progressDialog.setCancelable(true);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String latestMovieUrl = ApiContract.LATEST_MOVIE;
            Request request =  new Request.Builder()
                    .url(latestMovieUrl)
                    .build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                String res = response.body().toString();
                JSONObject jsonObject = new JSONObject(res);

                id = jsonObject.getInt("id");
                title = jsonObject.getString("original_title");
                overview = jsonObject.getString("overview");
                popularity = jsonObject.getInt("popularity");
                backdrop_path = jsonObject.getString("backdrop_path") == null ? "" : jsonObject.getString("backdrop_path");
               poster_path = (jsonObject.getString("poster_path") == null) ? "" : jsonObject.getString("poster_path");

                tagline = jsonObject.getString("tagline");
                vote_count = jsonObject.getInt("vote_count");
                status = jsonObject.getString("status");
                original_language = jsonObject.getString("original_language");
                is_adult = jsonObject.getBoolean("adult");
                genres = jsonObject.getJSONArray("genres");
                runtime = jsonObject.getInt("runtime");
                revenue = jsonObject.getInt("revenue");
                budget = jsonObject.getInt("budget");
                release_date = jsonObject.getString("release_date");

                String data = poster_path + " " + backdrop_path + " " + overview + " " + release_date + " " + genres+ " " + String.valueOf(id) + " " + title + " " +  String.valueOf(popularity)+ " " + String.valueOf(vote_count) + " " + tagline + " " + status+ " " +original_language + " " + String.valueOf(is_adult) + " " + String.valueOf(runtime) + " " +String.valueOf(revenue) + " " + String.valueOf(budget);

                Log.d(HOMEFRAG_TAG, data);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                Log.d(HOMEFRAG_TAG, e.getMessage());
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
    /*END*/
}
