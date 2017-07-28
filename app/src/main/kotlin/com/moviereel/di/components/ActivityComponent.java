package com.moviereel.di.components;

import com.moviereel.di.PerActivity;
import com.moviereel.di.modules.ActivityModule;
import com.moviereel.ui.activities.customerror.CustomErrorActivity;
import com.moviereel.ui.activities.intro.AppIntroduction;
import com.moviereel.ui.activities.intro.splash.SplashActivity;
import com.moviereel.ui.activities.itemdetails.movie.MovieDetailsActivity;

import com.moviereel.ui.activities.main.MainActivity;
import com.moviereel.ui.activities.settings.SettingsActivity;
import com.moviereel.ui.fragments.movie.nowplaying.MovieNPFragment;

import dagger.Component;

/**
 * @author lusinabrian on 27/03/17
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(CustomErrorActivity customErrorActivity);

    void inject(AppIntroduction appIntroduction);

    void inject(MainActivity mainActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(MovieNPFragment movieNPFragment);

    void inject(MovieDetailsActivity movieDetails);
}
