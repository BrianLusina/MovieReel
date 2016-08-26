package com.moviereel.moviereel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moviereel.moviereel.movies.MovieAdapter;
import com.moviereel.moviereel.movies.MovieModel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 22/08/16 at 19:08
 * Description: Main screen of the application, will feature the latest movies
 */
public class HomeFragment extends Fragment{

    public static final String HOMEFRAG_TAG = HomeFragment.class.getSimpleName();
    private MovieAdapter movieAdapter;
    private List<MovieModel> movieList;
    private CoordinatorLayout coordinatorLayout;
    private OkHttpClient okHttpClient = new OkHttpClient();

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
        View rootView = inflater.inflate(R.layout.homefragment_layout, container, false);

        return rootView;
    }

    /*END*/
}
