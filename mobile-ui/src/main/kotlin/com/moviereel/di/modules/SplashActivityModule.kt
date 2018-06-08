package com.moviereel.di.modules

import dagger.Module
import android.app.Activity
import com.moviereel.di.components.SplashActivitySubComponent
import com.moviereel.ui.intro.splash.SplashActivity
import dagger.android.AndroidInjector
import dagger.android.ActivityKey
import dagger.multibindings.IntoMap
import dagger.Binds


/**
 * @author lusinabrian on 08/06/18.
 * @Notes Used to provide dependencies to Splash Activity
 */
@Module
abstract class SplashActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(SplashActivity::class)
    internal abstract fun bindSplashActivityInjectorFactory(builder: SplashActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}