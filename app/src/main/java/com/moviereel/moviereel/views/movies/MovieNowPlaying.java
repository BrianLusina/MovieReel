package com.moviereel.moviereel.views.movies;

import android.content.SharedPreferences;
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

import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.adapter.MovieAdapter;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.utils.IsNetwork;
import com.moviereel.moviereel.utils.RecyclerItemClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel.views.movies
 * Created by lusinabrian on 22/08/16 at 20:32
 * Description: displays the latest movies
 */
public class MovieNowPlaying extends Fragment{
    public static final String MOVIENOW_PLAYING_TAG = MovieNowPlaying.class.getSimpleName();
    private MovieAdapter movieAdapter;
    private List<MovieModel> MovieModelList;
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private MovieSync movieSync;

    public MovieNowPlaying(){}

    public static Fragment newInstance(){
        MovieNowPlaying movieNowPlaying = new MovieNowPlaying();
        movieNowPlaying.setRetainInstance(true);
        return movieNowPlaying;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieModelList = new ArrayList<>();
        movieSync = new MovieSync(getActivity(), MovieModelList);
        movieAdapter = new MovieAdapter(getActivity(), MovieModelList, R.layout.movie_item_layout);
        if(IsNetwork.isNetworkAvailable(getActivity())) {
            movieSync.execute();
        }else{
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, getString(R.string.snackbar_warning_no_internet_conn), Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.snackbar_no_internet_conn_retry), view -> {
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, getString(R.string.snackbar_no_internet_conn_retry), Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    });
            snackbar.show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movierecy_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.movie_recy_recyclerview_id);
        coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.movie_recy_coordinator_layout);

        SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.movie_recy_swiperefresh_layout_id);

        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.dark_slate_blue,
                R.color.dark_slate_gray,
                R.color.dark_cyan,
                R.color.dark_turquoise,
                R.color.dark_sea_green);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setAdapter(movieAdapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //implement item click listener
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                (view1, position) -> {
                    /*TODO: test*/
                }));
    }

/*END*/
}