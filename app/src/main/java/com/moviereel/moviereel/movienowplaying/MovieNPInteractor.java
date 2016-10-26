package com.moviereel.moviereel.movienowplaying;

import android.content.Context;

import com.moviereel.moviereel.models.MovieModel;

import java.util.List;

/**
 * MovieReel
 * com.moviereel.moviereel.movienowplaying
 * Created by lusinabrian on 26/10/16.
 * Description: Interactor for the Presenter Layer
 */

interface MovieNPInteractor {
    interface OnFinishedListener {
        /**on finished loading, set the movie items to the adapter*/
        void onFinished(List<MovieModel> items);
    }

    /**Find the items*/
    void findItems(Context context, OnFinishedListener listener);
}
