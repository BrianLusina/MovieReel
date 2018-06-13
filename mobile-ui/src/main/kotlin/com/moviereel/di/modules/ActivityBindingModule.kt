package com.moviereel.di.modules

import com.moviereel.di.modules.activities.MainActivityModule
import com.moviereel.di.modules.activities.SplashActivityModule
import com.moviereel.di.scopes.PerActivity
import com.moviereel.ui.intro.splash.SplashActivity
import com.moviereel.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author lusinabrian on 27/03/17
 * * Responsible for providing objects which can be injected. This is a dependency provider
 */

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun splashActivity(): SplashActivity
}
