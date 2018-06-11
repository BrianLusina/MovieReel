package com.moviereel.di.modules.activities

import com.moviereel.di.components.activities.MainActivitySubComponent
import com.moviereel.di.scopes.PerActivity
import com.moviereel.presentation.view.main.MainPresenter
import com.moviereel.presentation.view.main.MainPresenterImpl
import com.moviereel.presentation.view.main.MainView
import com.moviereel.ui.main.MainActivity
import dagger.Module
import dagger.Provides

/**
 * @author lusinabrian on 09/06/18.
 * @Notes Provides dependencies to [MainActivity]
 */
@Module(subcomponents = [MainActivitySubComponent::class])
class MainActivityModule {

    @Provides
    @PerActivity
    fun provideMainPresenter(mainPresenter: MainPresenterImpl<MainView>): MainPresenter<MainView> {
        return mainPresenter
    }
}