package com.moviereel.di.modules.activities

import com.moviereel.di.scopes.PerActivity
import com.moviereel.presentation.view.splash.SplashPresenter
import com.moviereel.presentation.view.splash.SplashPresenterImpl
import com.moviereel.presentation.view.splash.SplashView
import dagger.Module
import dagger.Provides


/**
 * @author lusinabrian on 08/06/18.
 * @Notes Used to provide dependencies to Splash Activity
 */
@Module
class SplashActivityModule {
//    @Binds
//    @IntoMap
//    @ActivityKey(SplashActivity::class)
//    internal abstract fun bindSplashActivityInjectorFactory(builder: SplashActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @Provides
    @PerActivity
    fun provideSplashPresenter(splashPresenter: SplashPresenterImpl<SplashView>): SplashPresenter<SplashView> {
        return splashPresenter
    }
}