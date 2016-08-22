package com.moviereel.moviereel;

import android.support.v4.app.Fragment;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 22/08/16 at 19:08
 * Description: Main screen of the application
 */
public class HomeFragment extends Fragment{

    /*empty constructor*/
    public HomeFragment(){}

    public static Fragment newInstance(){
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setRetainInstance(true);
        return  homeFragment;
    }

/*END*/
}
