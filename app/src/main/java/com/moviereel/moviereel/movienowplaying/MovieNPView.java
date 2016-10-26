package com.moviereel.moviereel.movienowplaying;

import com.moviereel.moviereel.models.MovieModel;

import java.util.List;

/**
 * MovieReel
 * com.moviereel.moviereel.movienowplaying
 * Created by lusinabrian on 26/10/16.
 * Description: View Interface for {@link MovieNowPlaying}
 */

interface MovieNPView {

    /**handles displaying the progress dialog when fetching Now Playing items*/
    void showProgress();

    /**Dismisses the progress dialog when done fetching Now Playing items*/
    void dismissProgress();

    /**In case of any error, display a message to the user
     * @param message The message to display to the user
     * @param messageType The message type to display, whether an error or informative*/
    void displayToast(String message, int messageType);

    /**responsible for setting the items to the RecyclerView
     * @param movieModelList The List of Movie Objects fetched from Model layer*/
    void setItems(List<MovieModel> movieModelList);
}
