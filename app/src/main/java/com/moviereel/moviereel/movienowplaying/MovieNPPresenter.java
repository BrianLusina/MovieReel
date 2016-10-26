package com.moviereel.moviereel.movienowplaying;

/**
 * MovieReel
 * com.moviereel.moviereel.movienowplaying
 * Created by lusinabrian on 26/10/16.
 * Description: Presenter interface that acts as the middleman between the {@link MovieNowPlaying}
 * and Model layer
 */

interface MovieNPPresenter {
    /**Handles what will happen when the Fragment is resumed*/
    void onResume();

    /**picks the data of the item clicked in the RecyclerView
    start activity for the clicked movie item*/
    void onItemClicked(String bundleKey, int moviePosition);

    /**Handles what will happen when the Fragment is destroyed*/
    void onDestroy();
}
