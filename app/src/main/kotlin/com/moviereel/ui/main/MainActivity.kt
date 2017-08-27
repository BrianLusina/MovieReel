package com.moviereel.ui.main

import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.LibsBuilder
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.SectionDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.Nameable
import com.moviereel.R
import com.moviereel.ui.base.BaseActivity
import com.moviereel.ui.movie.MoviesFragment
import com.moviereel.ui.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView {

    lateinit var drawer: Drawer

    @Inject
    lateinit var mainPresenter: MainPresenter<MainView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent?.inject(this)

        mainPresenter.onAttach(this)

        setUp()
        setUpNavigationMenu(savedInstanceState)
    }

    /**
     * Abstract method that will be implemented by child activity classes
     * used to setup the views in the activity
     */
    override fun setUp() {
        setSupportActionBar(toolbar_id)

        //sets the default fragment
        val fragment = MoviesFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment)
        fragmentTransaction.commit()
    }

    /**
     * Sets up the navigation menu
     * @param savedInstanceState Bundle with the current state of the activity
     * *
     */
    private fun setUpNavigationMenu(savedInstanceState: Bundle?) {
        //this layout have to contain child layouts
        drawer = DrawerBuilder(this)
                .withToolbar(toolbar_id)
                .withDisplayBelowStatusBar(true)
                .withRootView(R.id.drawer_container)
                .withSliderBackgroundColorRes(R.color.background_drawer_color)
                .addDrawerItems(
                        /*movies section*/
                        PrimaryDrawerItem().withName(R.string.main_drawer_movie_title)
                                .withIcon(FontAwesome.Icon.faw_play)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3)).withSelectedTextColor(
                                ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat.getColor(this,
                                        R.color.background_drawer_color))
                                .withIdentifier(1),


                        /*Tv series section*/
                        SectionDrawerItem().withName(R.string.main_drawer_series_title)
                                .withTextColor(ContextCompat.getColor(this, R.color.light_red3)),

                        /*Latest series*/
                        SecondaryDrawerItem().withName(R.string.main_drawer_series_latest)
                                .withIcon(FontAwesome.Icon.faw_clock_o)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(5),

                        /*On the air*/
                        SecondaryDrawerItem().withName(R.string.main_drawer_series_ontheair)
                                .withIcon(FontAwesome.Icon.faw_television)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(6),

                        /*Airing today*/
                        SecondaryDrawerItem().withName(R.string.main_drawer_series_airing_today)
                                .withIcon(FontAwesome.Icon.faw_hourglass_start)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(7),

                        /*top rated*/
                        SecondaryDrawerItem().withName(R.string.main_drawer_series_top_rated)
                                .withIcon(FontAwesome.Icon.faw_star)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3)).withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(8),

                        /*Popular tv shows*/
                        SecondaryDrawerItem().withName(R.string.main_drawer_series_popular)
                                .withIcon(FontAwesome.Icon.faw_bullhorn)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(9),

                        /*HELP section*/
                        SecondaryDrawerItem().withName(R.string.main_drawer_help)
                                .withIcon(FontAwesome.Icon.faw_question)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(10),

                        /*settings*/
                        SecondaryDrawerItem().withName(R.string.main_drawer_settings)
                                .withIcon(FontAwesome.Icon.faw_cogs)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(11),

                        /*About*/
                        SecondaryDrawerItem().withName(R.string.main_drawer_about)
                                .withIcon(FontAwesome.Icon.faw_exclamation)
                                .withIconColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedIconColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withSelectedTextColor(ContextCompat.getColor(this, R.color.light_red3))
                                .withTextColor(ContextCompat.getColor(this, R.color.white))
                                .withSelectedColor(ContextCompat
                                        .getColor(this, R.color.background_drawer_color))
                                .withIdentifier(12)

                ).withOnDrawerItemClickListener(
                Drawer.OnDrawerItemClickListener { view, position, drawerItem ->
                    if (drawerItem is Nameable<*>) {
                        val name = (drawerItem as Nameable<*>).name.getText(this)
                        supportActionBar?.title = name

                        when (drawerItem.identifier.toInt()) {
                        //movies
                            1 -> {
                                mainPresenter.onDrawerOptionMoviesClicked()
                                return@OnDrawerItemClickListener true
                            }


                        /*Latest series*/
                            5 -> {
                                mainPresenter.onDrawerOptionLatestSeriesClicked()
                                return@OnDrawerItemClickListener true
                            }

                        /*series On the air*/
                            6 -> {
                                mainPresenter.onDrawerOptionOnTheAirSeriesClicked()
                                return@OnDrawerItemClickListener true
                            }

                        /*Series airing today*/
                            7 -> {
                                mainPresenter.onDrawerOptionAiringTodaySeriesClicked()
                                return@OnDrawerItemClickListener true
                            }

                        /*top rated series*/
                            8 -> {
                                mainPresenter.onDrawerOptionTopRatedSeriesClicked()
                                return@OnDrawerItemClickListener true
                            }

                        /*Popular series*/
                            9 -> {
                                mainPresenter.onDrawerOptionPopularSeriesClicked()
                                return@OnDrawerItemClickListener true
                            }

                        /*help*/
                            10 -> {
                                mainPresenter.onDrawerOptionHelpClicked()
                                return@OnDrawerItemClickListener true
                            }

                        /*settings*/
                            11 -> {
                                mainPresenter.onDrawerOptionSettingsClicked()
                                return@OnDrawerItemClickListener true
                            }

                        /*about*/
                            12 -> {
                                mainPresenter.onDrawerOptionAboutClicked()
                                return@OnDrawerItemClickListener true
                            }
                        }
                    }
                    false
                })
                .withSavedInstance(savedInstanceState)
                .build()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        //add the values which need to be saved from the drawer to the bundle
        val state = drawer.saveInstanceState(outState)
        super.onSaveInstanceState(state)
    }

    override fun onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (drawer != null && drawer.isDrawerOpen) {
            drawer.closeDrawer()
        } else {
            super.onBackPressed()
        }
    }

    /**
     * Shows the movies that are now playing
     */
    override fun showMoviesFragment() {
        supportFragmentManager.beginTransaction().disallowAddToBackStack()
                .add(R.id.frame_container, MoviesFragment(), MoviesFragment.TAG).commit()
    }


    /**
     * Show the series that are the latest
     */
    override fun showLatestSeriesFragment() {

    }

    /**
     * Show the tv series that are on the air currently
     */
    override fun showOnTheAirSeriesFragment() {

    }

    /**
     * Display the tv series that are airing today
     */
    override fun showAiringTodaySeriesFragment() {

    }

    /**
     * Display the top rated series
     */
    override fun showTopRatedSeriesFragment() {

    }

    /**
     * Displays the popular series fragment
     */
    override fun showPopularSeriesFragment() {

    }

    /**
     * Display a help section
     */
    override fun showHelpSection() {

    }

    /**
     * Displays the setting screen
     */
    override fun showSettingsScreen() {
        startActivity<SettingsActivity>()
    }

    /**
     * displays an about fragment
     */
    override fun showAboutFragment() {
        LibsBuilder()
                .withActivityStyle(Libs.ActivityStyle.DARK)
                .withVersionShown(true)
                .withAboutAppName(getString(R.string.app_name))
                .withAboutDescription(getString(R.string.about_app))
                .withAboutIconShown(true)
                .start(this@MainActivity)
    }
}
