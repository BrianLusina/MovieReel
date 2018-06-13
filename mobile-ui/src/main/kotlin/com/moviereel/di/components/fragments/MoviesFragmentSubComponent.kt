package com.moviereel.di.components.fragments

import com.moviereel.ui.entertain.movie.MoviesFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

interface MoviesFragmentSubComponent : AndroidInjector<MoviesFragment>{

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesFragment>()
}