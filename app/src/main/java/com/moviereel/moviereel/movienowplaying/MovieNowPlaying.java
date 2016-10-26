package com.moviereel.moviereel.movienowplaying;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moviereel.moviereel.R;
import com.moviereel.moviereel.adapter.MovieAdapter;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.tasks.MovieSync;
import com.moviereel.moviereel.utils.IsNetwork;
import com.moviereel.moviereel.utils.RecyclerItemClickListener;
import com.moviereel.moviereel.views.movies.MovieDetails;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel.views.movies
 * Created by lusinabrian on 22/08/16 at 20:32
 * Description: displays the latest movies
 */
public class MovieNowPlaying extends Fragment implements MovieNPView{

    @BindView(R.id.movie_recy_recyclerview_id) RecyclerView recyclerView;
    @BindView(R.id.movie_recy_coordinator_layout) CoordinatorLayout coordinatorLayout;
    @BindView(R.id.movie_recy_swiperefresh_layout_id) SwipeRefreshLayout mSwipeRefreshLayout;

    private MovieNPPresenter movieNPPresenter;
    private SweetAlertDialog progressDialog;

    /**Empty required public constructor*/
    public MovieNowPlaying(){}

    public static Fragment newInstance(){
        MovieNowPlaying movieNowPlaying = new MovieNowPlaying();
        movieNowPlaying.setRetainInstance(true);
        return movieNowPlaying;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        movieModelList = new ArrayList<>();
        MovieSync movieSync = new MovieSync(getActivity(), movieModelList);

        if(IsNetwork.isNetworkAvailable(getActivity())) {
            movieSync.execute();
        }else{
            //display tasty toast of no network connection
            TastyToast.makeText(getActivity(),getResources().getString(R.string.snackbar_warning_no_internet_conn), TastyToast.LENGTH_SHORT,TastyToast.ERROR);
        }
*/

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movierecy_layout, container, false);
        ButterKnife.bind(this, rootView);

        //TODO: set the swipe refresh layout to fetch more data
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

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //implement item click listener
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                (view1, position) -> {
                    /** collect data, mostly the id from the clicked item, transfer to the next activity
                     * for display**/
                    Intent showMovieDet = new Intent(getActivity(),MovieDetails.class);
                    showMovieDet.putExtra("MovieObj", movieModelList.get(position));
                    startActivity(showMovieDet);
                }));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void displayToast(String message, int messageType) {

    }

    @Override
    public void setItems(List<MovieModel> movieModelList) {
        recyclerView.setAdapter(new MovieAdapter(getActivity(), movieModelList, R.layout.movie_item_layout));
    }

    @Override
    public void startActivityForClickedItem(String bundleKey, int moviePosition) {
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                (view1, position) -> {
                    Intent showMovieDet = new Intent(getActivity(),MovieDetails.class);
                    showMovieDet.putExtra(bundleKey, moviePosition);
                    startActivity(showMovieDet);
                }));
    }

/*END*/
}