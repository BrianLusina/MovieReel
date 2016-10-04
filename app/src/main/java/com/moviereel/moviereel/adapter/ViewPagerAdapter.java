package com.moviereel.moviereel.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.moviereel.moviereel.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

/**
 * MovieReel
 * com.moviereel.moviereel.adapter
 * Created by lusinabrian on 02/10/16.
 * Description: Fragment Pager adapter to implement adding Fragments to the MovieDetail View
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();
    private MovieModel movieModel;

    public ViewPagerAdapter(FragmentManager fm, MovieModel movieModel) {
        super(fm);
        this.movieModel = movieModel;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /**Adds fragment to the viewpager
     * @param fragment The fragment to add to the viewpager
     * @param fragTitle The title of the fragment*/
    public void addFragment(Fragment fragment, String fragTitle){
        fragmentList.add(fragment);
        fragmentTitleList.add(fragTitle);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}
