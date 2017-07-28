package com.moviereel.ui.fragments.movie.nowplaying;

import com.moviereel.data.db.models.movie.MovieNowPlayingModel;
import com.moviereel.di.PerActivity;
import com.moviereel.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by lusinabrian on 26/10/16.
 * Description: Presenter interface that acts as the middleman between the {@link MovieNPFragment}
 * and Model layer
 */

@PerActivity
public interface MovieNPPresenter<V extends MovieNPView> extends BasePresenter<V>{

    void onViewInitialized();

    /**Handles what will happen when the Fragment is resumed*/
    void onResume();

    /**picks the data of the item clicked in the RecyclerView
    start activity for the clicked movie item*/
    void onItemClicked(String bundleKey, List<MovieNowPlayingModel> movieList);

    /**Handles what will happen when the Fragment is destroyed*/
    void onDestroy();
}
