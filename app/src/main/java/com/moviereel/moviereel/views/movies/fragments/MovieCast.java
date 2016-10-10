package com.moviereel.moviereel.views.movies.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.moviereel.moviereel.R;
import com.moviereel.moviereel.adapter.MovieAdapter;
import com.moviereel.moviereel.adapter.MovieCastAdapter;
import com.moviereel.moviereel.models.ActorModel;
import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.utils.IsNetwork;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Credits;
import info.movito.themoviedbapi.model.people.PersonCast;

import static com.moviereel.moviereel.models.Contract.MOVIE_PARCEL_KEY;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies.fragments
 * Created by lusinabrian on 02/10/16.
 * Description: The cast of the movie, displays images and actor names*/

public class MovieCast extends Fragment {
    public static final String MOVIECAST_TAG = MovieCast.class.getSimpleName();
    @BindView(R.id.moviecast_recyclerView) RecyclerView movieCastRecycler;
    private MovieCastAdapter movieCastAdapter;
    private SweetAlertDialog progressDialog;

    public MovieCast(){}

    public static Fragment newInstance(){
        MovieCast movieCast = new MovieCast();
        movieCast.setRetainInstance(true);
        return movieCast;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrieve the arguments and set them to the movie model
        Bundle bundle = getArguments();
        MovieModel movieModel = bundle.getParcelable(MOVIE_PARCEL_KEY);
        Log.d(MOVIECAST_TAG+"BundleReceived:", movieModel != null ? movieModel.getMovie_title() : null);

        // fetch the cast
        List<ActorModel> actorModelList = new ArrayList<>();
        MovieCastTask fetchCastTask = new MovieCastTask(getActivity(), actorModelList, movieModel);

        //check for internet connection
        if(IsNetwork.isNetworkAvailable(getActivity())) {
            fetchCastTask.execute();
        }else{
            //display tasty toast of no network connection
            TastyToast.makeText(getActivity(),getResources().getString(R.string.snackbar_warning_no_internet_conn), TastyToast.LENGTH_SHORT,TastyToast.ERROR);
        }

        movieCastAdapter = new MovieCastAdapter(getActivity(), actorModelList, R.layout.moviecast_item_layout);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.moviecast_layout, container, false);
        ButterKnife.bind(this, rootView);

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(),3);
        mGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        movieCastRecycler.setHasFixedSize(true);
        movieCastRecycler.setLayoutManager(mGridLayoutManager);
        movieCastRecycler.setAdapter(movieCastAdapter);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        movieCastRecycler.setAdapter(movieCastAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

/*------------------------------------************************************--------------------------*/
private class MovieCastTask extends AsyncTask<String, Void, List<ActorModel>> {
    private final String MOVIECASTTASK_TAG = MovieCastTask.class.getSimpleName();
    private List<ActorModel> actorModelList;
    private Context context;
    private MovieModel movieModel;

    public MovieCastTask(){}

    private MovieCastTask (Context context, List<ActorModel> actorModelList, MovieModel movieModel){
        this.context = context;
        this.actorModelList = actorModelList;
        this.movieModel = movieModel;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        progressDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.light_red3));
        progressDialog.setContentView(R.layout.custom_progress_layout);
        progressDialog.setTitleText("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    @Override
    protected List<ActorModel> doInBackground(String... params) {
        //pass an id to the movie to get details about the movie
        TmdbMovies currentMovie = new TmdbApi(Contract.MOVIE_DB_KEY).getMovies();
        Credits movieCredits = currentMovie.getCredits(movieModel.getMovie_id());
        ActorModel actorModel;

        /*Person cast Details*/
        int personCastCastId, personCastId,personCastOrder;
        String personCastCharacter,personCastCreditId,personCastName, personCastProfileImage;

        //get credits for the movie, that is cast and crew
        //get the details of the cast for this movie
        for (PersonCast personCast : movieCredits.getCast()) {
            personCastCastId = personCast.getCastId();
            personCastId = personCast.getId();
            personCastCharacter = personCast.getCharacter();
            personCastCreditId = personCast.getCreditId();
            personCastName = personCast.getName();
            personCastOrder = personCast.getOrder();
            personCastProfileImage = Contract.MOVIE_POSTER_PATH + personCast.getProfilePath();

            //add these to a model object, the model object to the list which will populate recyclerView
            actorModel = new ActorModel(personCastId, personCastCastId, personCastOrder, personCastCreditId, personCastName, personCastProfileImage, personCastCharacter);

            // add object to list
            actorModelList.add(actorModel);
        }

        Log.d(MOVIECASTTASK_TAG, actorModelList.toString());
        return actorModelList;
    }

    @Override
    protected void onPostExecute(List<ActorModel> actorModelList) {
        super.onPostExecute(actorModelList);
        if(progressDialog.isShowing()){
            progressDialog.dismissWithAnimation();
        }
        // initialize the MovieCastAdapter
        movieCastAdapter = new MovieCastAdapter(getActivity(), actorModelList, R.layout.moviecast_item_layout);
    }
}


/*THE END*/
}
