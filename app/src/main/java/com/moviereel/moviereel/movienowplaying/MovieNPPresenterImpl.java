package com.moviereel.moviereel.movienowplaying;

import static com.moviereel.moviereel.utils.Constants.MOVIE_OBJ;

/**
 * MovieReel
 * com.moviereel.moviereel.movienowplaying
 * Created by lusinabrian on 26/10/16.
 * Description:
 */

class MovieNPPresenterImpl implements MovieNPPresenter {
    private MovieNPView movieNPView;


    public MovieNPPresenterImpl(MovieNPView movieNPView) {
        this.movieNPView = movieNPView;
    }

    @Override
    public void onResume() {
        if(movieNPView != null){
            movieNPView.showProgress();
        }

        /*find the items from the model layer*/

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
}
