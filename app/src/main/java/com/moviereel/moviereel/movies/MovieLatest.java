package com.moviereel.moviereel.movies;

import android.support.v4.app.Fragment;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel.movies
 * Created by lusinabrian on 22/08/16 at 20:32
 * <p/>
 * Description: displays the latest movies
 */
public class MovieLatest extends Fragment{
    public MovieLatest(){}

    public static Fragment newInstance(){
        MovieLatest movieLatest = new MovieLatest();
        movieLatest.setRetainInstance(true);
        return movieLatest;
    }

/*end*/
}
