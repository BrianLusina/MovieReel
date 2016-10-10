package com.moviereel.moviereel.views.movies.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moviereel.moviereel.R;
import com.moviereel.moviereel.adapter.MovieImageAdapter;
import com.moviereel.moviereel.models.ActorModel;
import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.ImagesModel;
import com.moviereel.moviereel.models.MovieModel;
import com.moviereel.moviereel.utils.IsNetwork;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieImages;

import static com.moviereel.moviereel.models.Contract.MOVIE_PARCEL_KEY;

/**
 * MovieReel
 * com.moviereel.moviereel.views.movies.fragments
 * Created by lusinabrian on 02/10/16.
 * Description:
 */

public class MovieImagesFrag extends Fragment {
    public static final String MOVIEIMAGES_TAG = MovieImagesFrag.class.getSimpleName();
    @BindView(R.id.movieimages_recyclerView) RecyclerView mMovieRecyclerView;
    private MovieImageAdapter movieImageAdapter;

    public MovieImagesFrag(){}

    public static Fragment newInstance(){
        MovieImagesFrag movieImagesFrag = new MovieImagesFrag();
        movieImagesFrag.setRetainInstance(true);
        return movieImagesFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrieve the arguments and set them to the movie model
        Bundle bundle = getArguments();
        MovieModel movieModel = bundle.getParcelable(MOVIE_PARCEL_KEY);
        Log.d(MOVIEIMAGES_TAG+"BundleReceivedFor:", movieModel != null ? movieModel.getMovie_title() : null);

        // fetch the Images
        List<ImagesModel> movieImagesList = new ArrayList<>();
        MovieImagesTask fetchImagesTask = new MovieImagesTask(getActivity(), movieImagesList, movieModel);

        //check for internet connection
        if(IsNetwork.isNetworkAvailable(getActivity())) {
            fetchImagesTask.execute();
        }else{
            //display tasty toast of no network connection
            TastyToast.makeText(getActivity(),getResources().getString(R.string.snackbar_warning_no_internet_conn), TastyToast.LENGTH_SHORT,TastyToast.ERROR);
        }

        //set the adapter
        mMovieRecyclerView.setAdapter(movieImageAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movieimages_layout, container, false);
        ButterKnife.bind(this, rootView);
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
        mMovieRecyclerView.setAdapter(movieImageAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

/*------------------------------------************************************--------------------------*/

    /**Task to fetch Movie images for this particular movie*/
    private class MovieImagesTask extends AsyncTask<String, Void, List<ImagesModel>> {
        private final String MOVIECASTTASK_TAG = MovieImagesTask.class.getSimpleName();
        private List<ImagesModel> imagesModelsList;
        private Context context;
        private MovieModel movieModel;

        public MovieImagesTask(){}

        private MovieImagesTask (Context context, List<ImagesModel> imagesModelList, MovieModel movieModel){
            this.context = context;
            this.imagesModelsList = imagesModelList;
            this.movieModel = movieModel;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<ImagesModel> doInBackground(String... params) {
            //pass an id to the movie to get details about the movie
            TmdbMovies currentMovie = new TmdbApi(Contract.MOVIE_DB_KEY).getMovies();
            MovieImages movieImages = currentMovie.getImages(movieModel.getMovie_id(), "en");
            ImagesModel imagesModel;

            return null;
        }

        @Override
        protected void onPostExecute(List<ImagesModel> imagesModelList) {
            super.onPostExecute(imagesModelList);
        }
}

}
