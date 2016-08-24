package com.moviereel.moviereel.movies;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.moviereel.moviereel.APIUrlEndpoints;
import com.moviereel.moviereel.R;

import java.io.IOException;
import java.util.List;

import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel.movies
 * Created by lusinabrian on 22/08/16 at 20:32
 * <p/>
 * Description: displays the latest movies
 */
public class MovieNowPlaying extends Fragment{
    private static final String MOVIELATEST_TAG = MovieNowPlaying.class.getSimpleName();
    private MovieAdapter movieAdapter;
    private List<MovieModel> foodModelList;
    private CoordinatorLayout coordinatorLayout;
    private LoadMoviesTask loadMovies;
    private OkHttpClient client = new OkHttpClient();

    public MovieNowPlaying(){}

    public static Fragment newInstance(){
        MovieNowPlaying movieNowPlaying = new MovieNowPlaying();
        movieNowPlaying.setRetainInstance(true);
        return movieNowPlaying;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isNetworkAvailable()) {
            loadMovies.execute();
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
        View rootView = inflater.inflate(R.layout.movierecy_layout, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.movie_recy_recyclerview_id);
        coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.movie_recy_coordinator_layout);

        SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.movie_recy_swiperefresh_layout_id);

        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.dark_slate_blue,
                R.color.dark_slate_gray,
                R.color.dark_cyan,
                R.color.dark_yellow,
                R.color.dark_turquoise,
                R.color.dark_sea_green);

        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(movieAdapter);
        alphaAdapter.setInterpolator(new OvershootInterpolator());
        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new LandingAnimator());
        recyclerView.setAdapter(scaleAdapter);
        return rootView;
    }

    /**
     Method to check network availability
     Using ConnectivityManager to check for Network Connection
     * */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    /**
     * Method to load movies task, works on a separate thread*/
    private class LoadMoviesTask extends AsyncTask<String, Void, String> {
        APIUrlEndpoints APIURLs = new APIUrlEndpoints();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //TODO: add an indeterminate spinner
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Request request = new Request.Builder()
                            .url(APIURLs.getNowPlaying())
                            .build();
                Response response = client.newCall(request).execute();
                String res = response.body().string();
                //TODO: Creating a JSON object, parsing through it, adding the data to a model and the adapter
                Log.d(MOVIELATEST_TAG, res);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //TODO: post results and kill of spinner
        }
    }

/*END*/
}