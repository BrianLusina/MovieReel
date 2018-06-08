package com.moviereel.di.components

import com.moviereel.di.scopes.PerActivity
import com.moviereel.di.modules.ActivityModule
import com.moviereel.ui.customerror.CustomErrorActivity
import com.moviereel.ui.intro.AppIntroduction
import com.moviereel.ui.intro.splash.SplashActivity
import com.moviereel.ui.detail.MovieDetailsActivity

import com.moviereel.ui.main.MainActivity
import com.moviereel.ui.entertain.movie.MoviesFragment
import com.moviereel.ui.settings.SettingsActivity
import com.moviereel.ui.entertain.movie.nowplaying.NowPlayingFragment
import com.moviereel.ui.entertain.movie.popular.MoviePopularFrag
import com.moviereel.ui.entertain.movie.toprated.MovieTopRatedFrag
import com.moviereel.ui.entertain.movie.upcoming.MovieUpcomingFrag

import dagger.Component

/**
 * @author lusinabrian on 27/03/17
 */
@PerActivity
@Component(dependencies = [(AppComponent::class)], modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(customErrorActivity: CustomErrorActivity)

    fun inject(appIntroduction: AppIntroduction)

    fun inject(mainActivity: MainActivity)

    fun inject(settingsActivity: SettingsActivity)

    fun inject(moviesFragment: MoviesFragment)

    fun inject(movieNPFragment: NowPlayingFragment)

    fun inject(moviePopularFrag: MoviePopularFrag)

    fun inject(movieTopRatedFrag: MovieTopRatedFrag)

    fun inject(movieUpcomingFrag: MovieUpcomingFrag)

    fun inject(movieDetails: MovieDetailsActivity)
}
