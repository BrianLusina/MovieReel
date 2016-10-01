package com.moviereel.moviereel.views;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.views.movies.MovieNowPlaying;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 09:17
 * Description: Contains the RecyclerView for the movie items
 * Allows the user to refresh using a swipe refresh
 */
public class MainActivity extends AppCompatActivity{
    private static final  String MAINACTIVITY_TAG = MainActivity.class.getSimpleName();
    private Drawer drawer;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity_layout);
        initUiCtrls();

        //this layout have to contain child layouts
        drawer = new DrawerBuilder(this)
                .withToolbar(mToolbar)
                .withDisplayBelowStatusBar(false)
                .withRootView(R.id.drawer_container)
                .withSliderBackgroundColorRes(R.color.background_drawer_color)
                .addDrawerItems(
                        /*movies section*/
                        new SectionDrawerItem().withTextColor(getResources().getColor(R.color.light_red3)).withName(R.string.main_drawer_movie_title),

                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_now_playing).withIcon(FontAwesome.Icon.faw_play).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(1),

                        /*Popular shows*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_popular).withIcon(FontAwesome.Icon.faw_star).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(2),

                        /*Top rated movies*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_top_rated).withIcon(FontAwesome.Icon.faw_fire).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(3),

                        /*Upcoming movies*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_upcoming).withIconColor(getResources().getColor(R.color.white)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withIdentifier(4),

                        /*Tv series section*/
                        new SectionDrawerItem().withName(R.string.main_drawer_series_title).withTextColor(getResources().getColor(R.color.white)),
                        /*Latest series*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_latest).withIcon(FontAwesome.Icon.faw_clock_o).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(5),

                        /*On the air*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_ontheair).withIcon(FontAwesome.Icon.faw_television).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(6),

                        /*Airing today*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_airing_today).withIcon(FontAwesome.Icon.faw_hourglass_start).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(7),

                        /*top rated*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_top_rated).withIcon(FontAwesome.Icon.faw_star).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(8),

                        /*Popular tv shows*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_popular).withIcon(FontAwesome.Icon.faw_bullhorn).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(9),

                        /*HELP section*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_help).withIcon(FontAwesome.Icon.faw_question).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(10),

                        /*settings*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_settings).withIcon(FontAwesome.Icon.faw_cogs).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(11),

                        new SecondaryDrawerItem().withName(R.string.main_drawer_about).withIcon(FontAwesome.Icon.faw_exclamation).withIconColor(getResources().getColor(R.color.white)).withSelectedIconColor(getResources().getColor(R.color.light_red3)).withSelectedTextColor(getResources().getColor(R.color.light_red3)).withTextColor(getResources().getColor(R.color.white)).withSelectedColor(getResources().getColor(R.color.background_drawer_color)).withIdentifier(12)

                ).withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    if(drawerItem instanceof Nameable){
                        Fragment fragment = null;
                        String name = ((Nameable) drawerItem).getName().getText(MainActivity.this);
                        getSupportActionBar().setTitle(name);
                        String title = "";
                        switch ((int) drawerItem.getIdentifier()){
                            /*now playing*/
                            case 1:
                                fragment = MovieNowPlaying.newInstance();
                                title = "Now Playing";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*Popular Movies*/
                            case 2:
                                title = "Popular";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*Top rated*/
                            case 3:
                                title = "Top Rated";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*Upcoming*/
                            case 4:
                                title = "Upcoming";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*Latest series*/
                            case 5:
                                title = "Latest Shows";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*series On the air*/
                            case 6:
                                title = "On The air";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*Series airing today*/
                            case 7:
                                title = "Airing Today";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*top rated series*/
                            case 8:
                                title = "Top Rated";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*Popular series*/
                            case 9:
                                title = "Popular";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*help*/
                            case 10:
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*settings*/
                            case 11:
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*about*/
                            case 12:
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;

                            /*default is Home screen*/
                            default:
                                fragment = MovieNowPlaying.newInstance();
                                title = "Now Playing";
                                Log.d(MAINACTIVITY_TAG, "Viewing " + title + " fragment.");
                                break;
                            }
                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frame_container, fragment);
                            fragmentTransaction.commit();
                            // set the toolbar title
                            getSupportActionBar().setTitle(title);
                        }
                    }
                    return false;
                })
                .withSavedInstance(savedInstanceState)
                .build();

        //sets the default fragment
        Fragment fragment = MovieNowPlaying.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
        // set the toolbar title
        getSupportActionBar().setTitle("Now Playing");

        //install the Custom Activity on crash
        CustomActivityOnCrash.install(this);
        //TODO: set to false in production
        CustomActivityOnCrash.setShowErrorDetails(true);
        CustomActivityOnCrash.setEnableAppRestart(true);
    }

    private void initUiCtrls() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main_id);
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = drawer.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
/*END*/
}
