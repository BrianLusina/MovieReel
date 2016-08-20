package com.moviereel.moviereel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import java.io.IOException;
import java.util.List;

import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 09:17
 * Description: Contains the RecyclerView for the movie items
 * Allows the user to refresh using a swipe refresh
 */
public class MainActivity extends AppCompatActivity{
    private static final  String MAINACTIVITY_TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private List<MovieModel> foodModelList;
    private CoordinatorLayout coordinatorLayout;
    private LoadMoviesTask loadMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity_layout);
        initUiCtrls();
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

    private void initUiCtrls() {
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview_id);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.movie_coordinator_layout);

        SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.main_swipe_refresh_layout_id);
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.dark_slate_blue,
                R.color.dark_slate_gray,
                R.color.dark_cyan,
                R.color.dark_yellow,
                R.color.dark_turquoise,
                R.color.dark_sea_green);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(movieAdapter);
        alphaAdapter.setInterpolator(new OvershootInterpolator());
        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new LandingAnimator());
        recyclerView.setAdapter(scaleAdapter);
    }

    /***
     * Method to load Bonds from NSE and post them to the UI
     */
    private class LoadMoviesTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            MovieFetch movieFetch = new MovieFetch();
            try {
                Log.d(MAINACTIVITY_TAG, movieFetch.fetchAllGenres());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    /**
     * Method to check network availability
     Using ConnectivityManager to check for Network Connection
     * */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

/*END*/
}
