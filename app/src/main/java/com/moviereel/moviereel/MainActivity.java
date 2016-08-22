package com.moviereel.moviereel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

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
                .addDrawerItems(
                        /*Home section*/
                        new PrimaryDrawerItem().withName(R.string.main_drawer_home_title).withIcon(FontAwesome.Icon.faw_home).withIdentifier(0),

                        /*movies section*/
                        new SectionDrawerItem().withName(R.string.main_drawer_movie_title),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_latest).withIcon(FontAwesome.Icon.faw_times).withIdentifier(1),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_now_playing).withIcon(FontAwesome.Icon.faw_play_circle).withIdentifier(2),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_popular).withIcon(FontAwesome.Icon.faw_star).withIdentifier(3),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_top_rated).withIcon(FontAwesome.Icon.faw_arrow_up).withIdentifier(4),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_upcoming).withIcon(FontAwesome.Icon.faw_calendar_check_o).withIdentifier(5),

                        /*Tv series section*/
                        new SectionDrawerItem().withName(R.string.main_drawer_series_title),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_latest).withIcon(FontAwesome.Icon.faw_calendar_plus_o).withIdentifier(6),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_ontheair).withIcon(FontAwesome.Icon.faw_television).withIdentifier(7),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_airing_today).withIcon(FontAwesome.Icon.faw_hourglass_start).withIdentifier(8),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_top_rated).withIcon(FontAwesome.Icon.faw_star).withIdentifier(9),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_popular).withIcon(FontAwesome.Icon.faw_bullhorn).withIdentifier(10),
                        new PrimaryDrawerItem().withName(R.string.main_drawer_help).withIcon(FontAwesome.Icon.faw_question).withIdentifier(11)
                        /*STICKY DRAWER ITEMS*/
                ).addStickyDrawerItems(
                        /*settings*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_settings).withIcon(FontAwesome.Icon.faw_cogs).withIdentifier(12),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_about).withIcon(FontAwesome.Icon.faw_exclamation).withIdentifier(13)
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if(drawerItem instanceof Nameable){
                            Fragment fragment = null;
                            String name = ((Nameable) drawerItem).getName().getText(MainActivity.this);
                            getSupportActionBar().setTitle(name);
                            String title = "";
                            switch ((int) drawerItem.getIdentifier()){
                                /*HOME*/
                                case 0:
                                    fragment = HomeFragment.newInstance();
                                    title = ((Nameable) drawerItem).getName().toString();
                                    break;

                                /*latest movies*/
                                case 1:
                                    break;

                                /*Now Playing*/
                                case 2:
                                    break;

                                /*Popular Movies*/
                                case 3:
                                    break;

                                /*Top rated*/
                                case 4:
                                    break;

                                /*Upcoming*/
                                case 5:
                                    break;

                                /*Latest series*/
                                case 6:
                                    break;

                                /*series On the air*/
                                case 7:
                                    break;

                                /*Series airing today*/
                                case 8:
                                    break;

                                /*top rated series*/
                                case 9:
                                    break;

                                /*Popular series*/
                                case 10:
                                    break;

                                /*help*/
                                case 11:
                                    break;

                                /*settings*/
                                case 12:

                                    break;

                                /*about*/
                                case 13:

                                    break;

                                /*default is Home screen*/
                                default:
                                    fragment = HomeFragment.newInstance();
                                    title = "Home";
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
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
    }

    private void initUiCtrls() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(mToolbar);
    }


    /**
     * Method to check network availability
     Using ConnectivityManager to check for Network Connection
     * */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
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
