package com.moviereel.di.components.activities

import com.moviereel.ui.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author lusinabrian on 09/06/18.
 * @Notes
 */
@Subcomponent
interface MainActivitySubComponent : AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}