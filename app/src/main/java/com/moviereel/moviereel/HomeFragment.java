package com.moviereel.moviereel;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.moviereel.moviereel.movies.MovieAdapter;
import com.moviereel.moviereel.movies.MovieModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;
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
    private Network network = new Network();

    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    private View mFab;
    private int mMaxScrollSize;
    private boolean mIsImageHidden;

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
        LoadMoviesTask loadMovies = new LoadMoviesTask();
        MovieModelList = new ArrayList<>();
        movieAdapter = new MovieAdapter(getActivity(), MovieModelList, R.layout.movie_item_layout);
        if(network.isNetworkAvailable(getActivity())) {
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
        View rootView = inflater.inflate(R.layout.movie_details_layout, container, false);
        mFab = rootView.findViewById(R.id.flexible_example_fab);
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.flexible_example_toolbar);

        AppBarLayout appbar = (AppBarLayout) rootView.findViewById(R.id.flexible_example_appbar);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (mMaxScrollSize == 0)
                    mMaxScrollSize = appBarLayout.getTotalScrollRange();

                int currentScrollPercentage = (Math.abs(i)) * 100
                        / mMaxScrollSize;

                if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
                    if (!mIsImageHidden) {
                        mIsImageHidden = true;

                        ViewCompat.animate(mFab).scaleY(0).scaleX(0).start();
                    }
                }

                if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
                    if (mIsImageHidden) {
                        mIsImageHidden = false;
                        ViewCompat.animate(mFab).scaleY(1).scaleX(1).start();
                    }
                }
            }
        });
        return rootView;
    }

    private class LoadMovie extends AsyncTask<String, Void, String>{
        APIUrlEndpoints APIURLs = new APIUrlEndpoints();
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
            Request request =  new Request.Builder()
                    .url(APIURLs.getLATEST_MOVIE())
                    .build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                String res = response.body().toString();

            } catch (IOException e) {
                e.printStackTrace();
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
