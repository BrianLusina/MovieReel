package com.moviereel.ui.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.moviereel.R;
import com.moviereel.ui.activities.settings.SettingsActivity;
import com.moviereel.ui.base.BaseActivity;
import com.moviereel.ui.fragments.movie.nowplaying.MovieNPFragment;
import com.moviereel.utils.ClassPreamble;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


@ClassPreamble(
        author = "Brian Lusina",
        date = "20/08/16",
        currentRevision = 3,
        briefDescription = "Main activity for application.",
        lastModified = "18/3/17",
        lastModifiedBy = "Brian Lusina",
        reviewers = "Brian Lusina"
)
public class MainActivity extends BaseActivity implements MainView{
    private static final String TAG = MainActivity.class.getSimpleName();
    private Drawer drawer;

    @BindView(R.id.toolbar_main_id) Toolbar mToolbar;

    @Inject
    MainPresenter<MainView> mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        getActivityComponent().inject(this);

        setUnbinder(ButterKnife.bind(this));

        mainPresenter.onAttach(this);

        setUp();
        setUpNavigationMenu(savedInstanceState);
    }

    /**
     * Abstract method that will be implemented by child activity classes
     * used to setup the views in the activity
     */
    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);

        //sets the default fragment
        Fragment fragment = new MovieNPFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Sets up the navigation menu
     * @param savedInstanceState Bundle with the current state of the activity
     * */
    private void setUpNavigationMenu(Bundle savedInstanceState) {
        //this layout have to contain child layouts
        drawer = new DrawerBuilder(this)
                .withToolbar(mToolbar)
                .withDisplayBelowStatusBar(false)
                .withRootView(R.id.drawer_container)
                .withSliderBackgroundColorRes(R.color.background_drawer_color)
                .addDrawerItems(
                        /*movies section*/
                        new SectionDrawerItem().withTextColor(
                                ContextCompat.getColor(this, R.color.light_red3))
                                .withName(R.string.main_drawer_movie_title),

                        /*Now playing*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_now_playing)
                                .withIcon(FontAwesome.Icon.faw_play)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3)).
                                withSelectedTextColor(
                                        ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat.getColor(this,
                                        R.color.background_drawer_color))
                                .withIdentifier(1),

                        /*Popular shows*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_popular)
                                .withIcon(FontAwesome.Icon.faw_star)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(2),

                        /*Top rated movies*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_top_rated)
                                .withIcon(FontAwesome.Icon.faw_fire)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(3),

                        /*Upcoming movies*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_movie_upcoming)
                                .withIcon(FontAwesome.Icon.faw_calendar)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(4),

                        /*Tv series section*/
                        new SectionDrawerItem().withName(R.string.main_drawer_series_title)
                                .withTextColor(ContextCompat.getColor(this, R.color.light_red3)),

                        /*Latest series*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_latest)
                                .withIcon(FontAwesome.Icon.faw_clock_o)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(5),

                        /*On the air*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_ontheair)
                                .withIcon(FontAwesome.Icon.faw_television)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(6),

                        /*Airing today*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_airing_today)
                                .withIcon(FontAwesome.Icon.faw_hourglass_start)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(7),

                        /*top rated*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_top_rated)
                                .withIcon(FontAwesome.Icon.faw_star)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3)).
                                withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(8),

                        /*Popular tv shows*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_series_popular)
                                .withIcon(FontAwesome.Icon.faw_bullhorn)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(9),

                        /*HELP section*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_help)
                                .withIcon(FontAwesome.Icon.faw_question)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(10),

                        /*settings*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_settings)
                                .withIcon(FontAwesome.Icon.faw_cogs)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(11),

                        /*About*/
                        new SecondaryDrawerItem().withName(R.string.main_drawer_about)
                                .withIcon(FontAwesome.Icon.faw_exclamation)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(12)

                ).withOnDrawerItemClickListener(
                        new Drawer.OnDrawerItemClickListener() {

                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                if(drawerItem instanceof Nameable){
                                    String name = ((Nameable) drawerItem).getName().getText(MainActivity.this);
                                    getSupportActionBar().setTitle(name);

                                    switch ((int) drawerItem.getIdentifier()){
                                        /*now playing*/
                                        case 1:
                                            mainPresenter.onDrawerOptionNowPlayingMoviesClicked();
                                            return true;

                                        /*Popular Movies*/
                                        case 2:
                                            mainPresenter.onDrawerOptionPopularMoviesClicked();
                                            return true;

                                        /*Top rated*/
                                        case 3:
                                            mainPresenter.onDrawerOptionTopRatedMoviesClicked();
                                            return true;

                                        /*Upcoming*/
                                        case 4:
                                            mainPresenter.onDrawerOptionUpcomingMoviesClicked();
                                            return true;

                                        /*Latest series*/
                                        case 5:
                                            mainPresenter.onDrawerOptionLatestSeriesClicked();
                                            return true;

                                        /*series On the air*/
                                        case 6:
                                            mainPresenter.onDrawerOptionOnTheAirSeriesClicked();
                                            return true;

                                        /*Series airing today*/
                                        case 7:
                                            mainPresenter.onDrawerOptionAiringTodaySeriesClicked();
                                            return true;

                                        /*top rated series*/
                                        case 8:
                                            mainPresenter.onDrawerOptionTopRatedSeriesClicked();
                                            return true;

                                        /*Popular series*/
                                        case 9:
                                            mainPresenter.onDrawerOptionPopularSeriesClicked();
                                            return true;

                                        /*help*/
                                        case 10:
                                            mainPresenter.onDrawerOptionHelpClicked();
                                            return true;

                                        /*settings*/
                                        case 11:
                                            mainPresenter.onDrawerOptionSettingsClicked();
                                            return true;

                                        /*about*/
                                        case 12:
                                            mainPresenter.onDrawerOptionAboutClicked();
                                            return true;
                                    }
                                }
                                return false;
                            }
                        })
                .withSavedInstance(savedInstanceState)
                .build();
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

    /**
     * Shows the movies that are now playing
     */
    @Override
    public void showNowPlayingMoviesFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .add(R.id.frame_container, new MovieNPFragment(), MovieNPFragment.Companion.getTAG())
                .commit();
    }

    /**
     * Fragment Show the shows that are most popular
     */
    @Override
    public void showPopularMoviesFragment() {

    }

    /**
     * Fragment to show the movies that are top rated
     */
    @Override
    public void showTopRatedMoviesFragment() {

    }

    /**
     * Fragment to show upcoming movies
     */
    @Override
    public void showUpcomingMoviesFragment() {

    }

    /**
     * Show the series that are the latest
     */
    @Override
    public void showLatestSeriesFragment() {

    }

    /**
     * Show the tv series that are on the air currently
     */
    @Override
    public void showOnTheAirSeriesFragment() {

    }

    /**
     * Display the tv series that are airing today
     */
    @Override
    public void showAiringTodaySeriesFragment() {

    }

    /**
     * Display the top rated series
     */
    @Override
    public void showTopRatedSeriesFragment() {

    }

    /**
     * Displays the popular series fragment
     */
    @Override
    public void showPopularSeriesFragment() {

    }

    /**
     * Display a help section
     */
    @Override
    public void showHelpSection() {

    }

    /**
     * Displays the setting screen
     */
    @Override
    public void showSettingsScreen() {
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
    }

    /**
     * displays an about fragment
     */
    @Override
    public void showAboutFragment() {
        new LibsBuilder()
                .withActivityStyle(Libs.ActivityStyle.DARK)
                .withVersionShown(true)
                .withAboutAppName(getString(R.string.app_name))
                .withAboutDescription(getString(R.string.about_app))
                .withAboutIconShown(true)
                .start(MainActivity.this);
    }
}
