package com.moviereel.moviereel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

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
                        new PrimaryDrawerItem().withName(R.string.main_drawer_home_title).withIcon(FontAwesome.Icon.faw_home).withIdentifier(0),
                        /*movies section*/
                        new SectionDrawerItem().withName(R.string.main_drawer_movie_title),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_latest).withIcon(FontAwesome.Icon.faw_times).withIdentifier(1),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_now_playing).withIcon(FontAwesome.Icon.faw_play_circle).withIdentifier(2),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_popular).withIcon(FontAwesome.Icon.faw_star).withIdentifier(3),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_top_rated).withIcon(FontAwesome.Icon.faw_arrow_up).withIdentifier(4),
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_upcoming).withIcon(FontAwesome.Icon.faw_calendar_check_o).withIdentifier(5)

                )
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
