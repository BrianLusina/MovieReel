package com.moviereel.di.modules

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.moviereel.di.qualifiers.ActivityContext
import com.moviereel.di.scopes.PerActivity
import com.moviereel.io.SchedulerProvider
import com.moviereel.io.SchedulerProviderImpl
import com.moviereel.presentation.view.entertain.movie.MovieFragPresenter
import com.moviereel.presentation.view.entertain.movie.MovieFragPresenterImpl
import com.moviereel.presentation.view.entertain.movie.MovieFragView
import com.moviereel.presentation.view.entertain.movie.detail.MovieDetailsPresenter
import com.moviereel.presentation.view.entertain.movie.detail.MovieDetailsPresenterImpl
import com.moviereel.presentation.view.entertain.movie.detail.MovieDetailsView
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingPresenter
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingPresenterImpl
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingView
import com.moviereel.presentation.view.entertain.movie.popular.PopularPresenter
import com.moviereel.presentation.view.entertain.movie.popular.PopularPresenterImpl
import com.moviereel.presentation.view.entertain.movie.popular.PopularView
import com.moviereel.presentation.view.entertain.movie.toprated.TopRatedPresenter
import com.moviereel.presentation.view.entertain.movie.toprated.TopRatedPresenterImpl
import com.moviereel.presentation.view.entertain.movie.toprated.TopRatedView
import com.moviereel.presentation.view.entertain.movie.upcoming.UpcomingPresenter
import com.moviereel.presentation.view.entertain.movie.upcoming.UpcomingPresenterImpl
import com.moviereel.presentation.view.entertain.movie.upcoming.UpcomingView
import com.moviereel.ui.entertain.movie.MoviesViewPagerAdapter
import com.moviereel.ui.entertain.movie.nowplaying.NowPlayingAdapter
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
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideSchedulers(): SchedulerProvider {
        return SchedulerProviderImpl()
    }
//
//    @Provides
//    @PerActivity
//    fun provideSplashPresenter(splashPresenter: SplashPresenterImpl<SplashView>): SplashPresenter<SplashView> {
//        return splashPresenter
//    }
//
//    @Provides
//    @PerActivity
//    fun provideMainPresenter(mainPresenter: MainPresenterImpl<MainView>): MainPresenter<MainView> {
//        return mainPresenter
//    }

    // ************************ MOVIES *******************
    @Provides
    @PerActivity
    fun provideMoviePresenter(movieFragPresenter: MovieFragPresenterImpl<MovieFragView>): MovieFragPresenter<MovieFragView> {
        return movieFragPresenter
    }

    // now playing
    @Provides
    @PerActivity
    fun provideMovieNpPresenter(nowPlayingPresenter: NowPlayingPresenterImpl<NowPlayingView>): NowPlayingPresenter<NowPlayingView> {
        return nowPlayingPresenter
    }

    @Provides
    fun provideMovieNpAdapter(): NowPlayingAdapter {
        return NowPlayingAdapter(ArrayList())
    }

    // popular
    @Provides
    @PerActivity
    fun provideMoviePopularPresenter(moviePopularPresenter: PopularPresenterImpl<PopularView>): PopularPresenter<PopularView> {
        return moviePopularPresenter
    }
//
//    @Provides
//    fun provideMoviePopularAdapter(): MoviePopularAdapter {
//        return MoviePopularAdapter(ArrayList())
//    }

    // top rated
    @Provides
    @PerActivity
    fun provideTopRatedPresenter(topRatedPresenter: TopRatedPresenterImpl<TopRatedView>): TopRatedPresenter<TopRatedView> {
        return topRatedPresenter
    }

//    /**
//     * Top Rated Movie adapter
//     * */
//    @Provides
//    @PerActivity
//    fun provideTopRatedMovieAdapter(): MovieTopRatedAdapter {
//        return MovieTopRatedAdapter(ArrayList())
//    }

    // upcoming
    @Provides
    @PerActivity
    fun provideUpcomingPresenter(upcomingPresenter: UpcomingPresenterImpl<UpcomingView>): UpcomingPresenter<UpcomingView> {
        return upcomingPresenter
    }

//    @Provides
//    @PerActivity
//    fun provideMovieUpcomingAdapter(): MovieUpcomingAdapter {
//        return MovieUpcomingAdapter(ArrayList())
//    }
//
    @Provides
    @PerActivity
    fun provideMovieDetailsPresenter(movieDetailsPresenter: MovieDetailsPresenterImpl<MovieDetailsView>): MovieDetailsPresenter<MovieDetailsView> {
        return movieDetailsPresenter
    }

    @Provides
    fun provideMovieViewPagerAdapter(): MoviesViewPagerAdapter {
        return MoviesViewPagerAdapter(mActivity.supportFragmentManager)
    }

}
