package com.moviereel.di.components

import com.moviereel.di.PerActivity
import com.moviereel.di.modules.ActivityModule
import com.moviereel.ui.activities.customerror.CustomErrorActivity
import com.moviereel.ui.activities.intro.AppIntroduction
import com.moviereel.ui.activities.intro.splash.SplashActivity
import com.moviereel.ui.activities.itemdetails.movie.MovieDetailsActivity

import com.moviereel.ui.activities.main.MainActivity
import com.moviereel.ui.activities.settings.SettingsActivity
import com.moviereel.ui.fragments.movie.nowplaying.MovieNPFragment

import dagger.Component

/**
 * @author lusinabrian on 27/03/17
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(splashActivity: SplashActivity)

    fun inject(customErrorActivity: CustomErrorActivity)

    fun inject(appIntroduction: AppIntroduction)

    fun inject(mainActivity: MainActivity)

    fun inject(settingsActivity: SettingsActivity)

    fun inject(movieNPFragment: MovieNPFragment)

    fun inject(movieDetails: MovieDetailsActivity)
}
