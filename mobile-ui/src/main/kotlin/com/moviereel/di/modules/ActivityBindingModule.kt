package com.moviereel.di.modules

import com.moviereel.di.modules.activities.MainActivityModule
import com.moviereel.di.modules.activities.SplashActivityModule
import com.moviereel.di.scopes.PerActivity
import com.moviereel.ui.intro.splash.SplashActivity
import com.moviereel.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author lusinabrian on 27/03/17
 * * Responsible for providing objects which can be injected. This is a dependency provider
 */

@Module
abstract class ActivityBindingModule {

//    @Provides
//    fun provideCompositeDisposable(): CompositeDisposable {
//        return CompositeDisposable()
//    }
//
//    @Provides
//    fun provideSchedulers(): SchedulerProvider {
//        return SchedulerProviderImpl()
//    }

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun splashActivity(): SplashActivity
//
//    // ************************ MOVIES *******************
//    @Provides
//    @PerActivity
//    fun provideMoviePresenter(movieFragPresenter: MovieFragPresenterImpl<MovieFragView>): MovieFragPresenter<MovieFragView> {
//        return movieFragPresenter
//    }
//
//    // now playing
//    @Provides
//    @PerActivity
//    fun provideMovieNpPresenter(nowPlayingPresenter: NowPlayingPresenterImpl<NowPlayingView>): NowPlayingPresenter<NowPlayingView> {
//        return nowPlayingPresenter
//    }
//
//    @Provides
//    fun provideMovieNpAdapter(): NowPlayingAdapter {
//        return NowPlayingAdapter(ArrayList())
//    }
//
//    // popular
//    @Provides
//    @PerActivity
//    fun provideMoviePopularPresenter(moviePopularPresenter: PopularPresenterImpl<PopularView>): PopularPresenter<PopularView> {
//        return moviePopularPresenter
//    }
////
////    @Provides
////    fun provideMoviePopularAdapter(): MoviePopularAdapter {
////        return MoviePopularAdapter(ArrayList())
////    }
//
//    // top rated
//    @Provides
//    @PerActivity
//    fun provideTopRatedPresenter(topRatedPresenter: TopRatedPresenterImpl<TopRatedView>): TopRatedPresenter<TopRatedView> {
//        return topRatedPresenter
//    }
//
////    /**
////     * Top Rated Movie adapter
////     * */
////    @Provides
////    @PerActivity
////    fun provideTopRatedMovieAdapter(): MovieTopRatedAdapter {
////        return MovieTopRatedAdapter(ArrayList())
////    }
//
//    // upcoming
//    @Provides
//    @PerActivity
//    fun provideUpcomingPresenter(upcomingPresenter: UpcomingPresenterImpl<UpcomingView>): UpcomingPresenter<UpcomingView> {
//        return upcomingPresenter
//    }
//
////    @Provides
////    @PerActivity
////    fun provideMovieUpcomingAdapter(): MovieUpcomingAdapter {
////        return MovieUpcomingAdapter(ArrayList())
////    }
////
//    @Provides
//    @PerActivity
//    fun provideMovieDetailsPresenter(movieDetailsPresenter: MovieDetailsPresenterImpl<MovieDetailsView>): MovieDetailsPresenter<MovieDetailsView> {
//        return movieDetailsPresenter
//    }
//
//    @Provides
//    fun provideMovieViewPagerAdapter(): MoviesViewPagerAdapter {
//        return MoviesViewPagerAdapter(mActivity.supportFragmentManager)
//    }

}
