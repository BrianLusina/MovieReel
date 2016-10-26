package com.moviereel.moviereel.movienowplaying;


import android.content.Context;

import com.moviereel.moviereel.models.MovieModel;

import java.util.List;

/**
 * MovieReel
 * com.moviereel.moviereel.movienowplaying
 * Created by lusinabrian on 26/10/16.
 * Description:
 */

class MovieNPPresenterImpl implements MovieNPPresenter, MovieNPInteractor.OnFinishedListener{
    private MovieNPView movieNPView;
    private MovieNPInteractor movieNPInteractor;
    private Context context;

    MovieNPPresenterImpl(Context context, MovieNPView movieNPView, MovieNPInteractor movieNPInteractor) {
        this.movieNPView = movieNPView;
        this.context = context;
        this.movieNPInteractor = movieNPInteractor;
    }

    @Override
    public void onResume() {
        if(movieNPView != null){
            movieNPView.showProgress();
        }

        /*find the items from the model layer*/
        movieNPInteractor.findItems(context, this);
    }

    @Override
    public void onItemClicked(String bundleKey, int position) {
        if(movieNPView != null){

            //fetch items from the clicked item
            movieNPView.startActivityForClickedItem(bundleKey, position);
        }
    }

    @Override
    public void onDestroy() {
        movieNPView = null;
    }

    @Override
    public void onFinished(List<MovieModel> items) {
        if(movieNPView != null){
            movieNPView.setItems(items);
            movieNPView.dismissProgress();
        }
    }

    @Override
    public void onNetworkError(String message, int messageType) {
        if(movieNPView != null){
            movieNPView.displayToast(message, messageType);
            movieNPView.dismissProgress();
        }
    }

    public MovieNPView getMainView() {
        return movieNPView;
    }
}
