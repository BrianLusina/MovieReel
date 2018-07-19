package com.moviereel.di.modules

import com.moviereel.di.modules.fragments.MoviesFragmentModule
import com.moviereel.di.scopes.PerActivity
import com.moviereel.ui.entertain.movie.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MoviesFragmentModule::class])
    abstract fun moviesFragment() : MoviesFragment
}