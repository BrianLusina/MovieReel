package com.moviereel.di.modules

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.data.io.SchedulerProviderImpl
import com.moviereel.di.qualifiers.ActivityContext
import com.moviereel.di.scopes.PerActivity
import com.moviereel.ui.detail.MovieDetailsPresenter
import com.moviereel.ui.detail.MovieDetailsPresenterImpl
import com.moviereel.ui.detail.MovieDetailsView
import com.moviereel.ui.intro.splash.SplashPresenter
import com.moviereel.ui.intro.splash.SplashPresenterImpl
import com.moviereel.ui.intro.splash.SplashView
import com.moviereel.ui.main.MainPresenter
import com.moviereel.ui.main.MainPresenterImpl
import com.moviereel.ui.main.MainView
import com.moviereel.ui.movie.*
import com.moviereel.ui.movie.nowplaying.MovieNPAdapter
import com.moviereel.ui.movie.nowplaying.MovieNPPresenter
import com.moviereel.ui.movie.nowplaying.MovieNPPresenterImpl
import com.moviereel.ui.movie.nowplaying.MovieNPView
import com.moviereel.ui.movie.popular.MoviePopularPresenter
import com.moviereel.ui.movie.popular.MoviePopularPresenterImpl
import com.moviereel.ui.movie.popular.MoviePopularView
import com.moviereel.ui.movie.toprated.MovieTopRatedPresenter
import com.moviereel.ui.movie.toprated.MovieTopRatedPresenterImpl
import com.moviereel.ui.movie.toprated.MovieTopRatedView
import com.moviereel.ui.movie.upcoming.MovieUpcomingPresenter
import com.moviereel.ui.movie.upcoming.MovieUpcomingPresenterImpl
import com.moviereel.ui.movie.upcoming.MovieUpcomingView
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author lusinabrian on 27/03/17
 * * Responsible for providing objects which can be injected. This is a dependency provider
 */

@Module
class ActivityModule(val mActivity: AppCompatActivity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return mActivity
    }

    @Provides
    fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideSchedulers(): SchedulerProvider {
        return SchedulerProviderImpl()
    }

    @Provides
    @PerActivity
    fun provideSplashPresenter(splashPresenter: SplashPresenterImpl<SplashView>): SplashPresenter<SplashView> {
        return splashPresenter
    }

    @Provides
    @PerActivity
    fun provideMainPresenter(mainPresenter: MainPresenterImpl<MainView>): MainPresenter<MainView> {
        return mainPresenter
    }

    // ************************ MOVIES *******************
    @Provides
    @PerActivity
    fun provideMoviePresenter(movieFragPresenter: MovieFragPresenterImpl<MovieFragView>): MovieFragPresenter<MovieFragView> {
        return movieFragPresenter
    }

    // now playing
    @Provides
    @PerActivity
    fun provideMovieNpPresenter(movieNPPresenter: MovieNPPresenterImpl<MovieNPView>): MovieNPPresenter<MovieNPView> {
        return movieNPPresenter
    }

    // popular
    @Provides
    @PerActivity
    fun provideMoviePopularPresenter(moviePopularPresenter: MoviePopularPresenterImpl<MoviePopularView>): MoviePopularPresenter<MoviePopularView> {
        return moviePopularPresenter
    }

    // top rated
    @Provides
    @PerActivity
    fun provideTopRatedPresenter(movieTopRatedPresenter: MovieTopRatedPresenterImpl<MovieTopRatedView>): MovieTopRatedPresenter<MovieTopRatedView> {
        return movieTopRatedPresenter
    }

    // upcoming
    @Provides
    @PerActivity
    fun provideUpcomingPresenter(movieUpcomingPresenter: MovieUpcomingPresenterImpl<MovieUpcomingView>): MovieUpcomingPresenter<MovieUpcomingView> {
        return movieUpcomingPresenter
    }

    @Provides
    @PerActivity
    fun provideMovieDetailsPresenter(movieDetailsPresenter: MovieDetailsPresenterImpl<MovieDetailsView>): MovieDetailsPresenter<MovieDetailsView> {
        return movieDetailsPresenter
    }

    @Provides
    fun provideMovieNpAdapter(): MovieNPAdapter {
        return MovieNPAdapter(ArrayList())
    }

    @Provides
    fun provideMovieAdapter() : MovieAdapter{
        return MovieAdapter(ArrayList())
    }

}
