package com.moviereel.di.components.activities

import com.moviereel.ui.intro.splash.SplashActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author lusinabrian on 08/06/18.
 * @Notes
 */
@Subcomponent
interface SplashActivitySubComponent : AndroidInjector<SplashActivity>{

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SplashActivity>()
}