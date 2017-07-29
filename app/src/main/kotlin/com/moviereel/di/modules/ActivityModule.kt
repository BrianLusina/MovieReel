package com.moviereel.di.modules

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.moviereel.data.api.model.BaseResultsResponse

import com.moviereel.di.ActivityContext
import com.moviereel.di.PerActivity
import com.moviereel.ui.intro.splash.SplashPresenter
import com.moviereel.ui.intro.splash.SplashPresenterImpl
import com.moviereel.ui.intro.splash.SplashView
import com.moviereel.ui.movie.MovieDetailsPresenter
import com.moviereel.ui.movie.MovieDetailsPresenterImpl
import com.moviereel.ui.movie.MovieDetailsView
import com.moviereel.ui.movie.MovieDetailsViewPagerAdapter
import com.moviereel.ui.main.MainPresenter
import com.moviereel.ui.main.MainPresenterImpl
import com.moviereel.ui.main.MainView
import com.moviereel.ui.movie.nowplaying.MovieNPAdapter
import com.moviereel.ui.movie.nowplaying.MovieNPPresenter
import com.moviereel.ui.movie.nowplaying.MovieNPPresenterImpl
import com.moviereel.ui.movie.nowplaying.MovieNPView

import java.util.ArrayList

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

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
    fun provideCompositeDisposible(): CompositeDisposable {
        return CompositeDisposable()
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

    @Provides
    @PerActivity
    fun provideMovieNpPresenter(movieNPPresenter: MovieNPPresenterImpl<MovieNPView>): MovieNPPresenter<MovieNPView> {
        return movieNPPresenter
    }

    @Provides
    @PerActivity
    fun provideMovieDetailsPresenter(movieDetailsPresenter: MovieDetailsPresenterImpl<MovieDetailsView>): MovieDetailsPresenter<MovieDetailsView> {
        return movieDetailsPresenter
    }

//    @Provides
//    fun provideMovieDetailsViewPagerAdapter(): MovieDetailsViewPagerAdapter {
//        return MovieDetailsViewPagerAdapter(
//                mActivity.supportFragmentManager,
//                BaseResultsResponse.MovieResultsResponse())
//    }

    @Provides
    fun provideMovieNpAdapter(): MovieNPAdapter {
        return MovieNPAdapter(ArrayList<BaseResultsResponse.MovieResultsResponse>())
    }

}
