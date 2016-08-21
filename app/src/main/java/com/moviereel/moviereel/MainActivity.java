package com.moviereel.moviereel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

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
                        new PrimaryDrawerItem().withName(R.string.)
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
