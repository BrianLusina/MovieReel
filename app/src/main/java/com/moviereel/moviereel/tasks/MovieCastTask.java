package com.moviereel.moviereel.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.moviereel.moviereel.models.ActorModel;
import com.moviereel.moviereel.models.Contract;
import com.moviereel.moviereel.models.MovieModel;

import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Credits;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.people.PersonCast;

/**
 * MovieReel
 * com.moviereel.moviereel.tasks
 * Created by lusinabrian on 06/10/16.
 * Description:Background async task that fetches data for the cast of the movie
 * Requires the ID of the movie to fetch that cast
 * */

public class MovieCastTask extends AsyncTask<String, Void, List<ActorModel>> {
    public static final String MOVIECASTTASK_TAG = MovieCastTask.class.getSimpleName();
    private List<ActorModel> actorModelList;
    private Context context;
    private MovieModel movieModel;

    public MovieCastTask(){}

    public MovieCastTask (Context context, List<ActorModel > actorModelList, MovieModel movieModel){
        this.context = context;
        this.actorModelList = actorModelList;
        this.movieModel = movieModel;
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
            Log.d(MOVIECASTTASK_TAG, actorModel.toString());
            // add object to list
            actorModelList.add(actorModel);
            Log.d(MOVIECASTTASK_TAG+"LIST", actorModelList.toString());
        }
        return actorModelList;
    }
}