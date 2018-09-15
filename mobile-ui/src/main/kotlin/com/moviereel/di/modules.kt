package com.moviereel.di

import com.moviereel.BuildConfig
import com.moviereel.cache.CacheManager
import com.moviereel.cache.CacheManagerImpl
import com.moviereel.cache.db.DbFactory
import com.moviereel.cache.db.MovieReelDatabase
import com.moviereel.cache.files.FileHelperImpl
import com.moviereel.cache.movies.MovieCache
import com.moviereel.cache.movies.MovieCacheImpl
import com.moviereel.cache.movies.nowplaying.NowPlaying
import com.moviereel.cache.movies.nowplaying.NowPlayingCacheMapper
import com.moviereel.cache.movies.nowplaying.NowPlayingImpl
import com.moviereel.cache.prefs.PreferencesHelper
import com.moviereel.cache.prefs.PreferencesHelperImpl
import com.moviereel.data.DataManager
import com.moviereel.data.source.DataCache
import com.moviereel.data.source.movies.repo.MovieLocalRepo
import com.moviereel.domain.DomainManager
import com.moviereel.io.SchedulerProviderImpl
import com.moviereel.mapper.movies.NowPlayingViewMapper
import com.moviereel.presentation.view.entertain.movie.MovieFragView
import com.moviereel.presentation.view.entertain.movie.MoviesPresenter
import com.moviereel.presentation.view.entertain.movie.MoviesPresenterImpl
import com.moviereel.presentation.view.main.MainPresenter
import com.moviereel.presentation.view.main.MainPresenterImpl
import com.moviereel.presentation.view.main.MainView
import com.moviereel.presentation.view.splash.SplashPresenter
import com.moviereel.presentation.view.splash.SplashPresenterImpl
import com.moviereel.presentation.view.splash.SplashView
import com.moviereel.remote.ApiServiceFactory
import com.moviereel.ui.entertain.movie.nowplaying.NowPlayingAdapter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * @author lusinabrian on 15/09/18.
 * @Notes Modules
 */

object Params{
    const val FRAGMENT_MANAGER = "FRAGMENT_MANAGER"
}

val applicationModule = module {
    single { SchedulerProviderImpl() }
}

val remoteModule = module {
    single { ApiServiceFactory.makeApiService(BuildConfig.DEBUG, BuildConfig.MOVIE_DB_API_KEY) }
}

val domainModule = module {
    single { DataManager(get()) }
    single<DomainManager> { DataManager(get()) }
}

val dataModule = module {
    single { CacheManagerImpl(get(), get()) }
    single<DataCache> { CacheManagerImpl(get(), get()) }
    single<CacheManager> { CacheManagerImpl(get(), get()) }
    single<MovieLocalRepo> { CacheManagerImpl(get(), get()) }
}

val cacheModule = module(override = true) {
    single { PreferencesHelperImpl(androidContext()) }

    single<PreferencesHelper> { PreferencesHelperImpl(androidContext()) }

    single { FileHelperImpl() }

    single { CacheManagerImpl(get(), get()) }

    single { MovieCacheImpl(get()) }

    single<MovieCache> { MovieCacheImpl(get()) }

    single { NowPlayingCacheMapper() }

    single { NowPlayingImpl(get(), get()) }

    single<NowPlaying> { NowPlayingImpl(get(), get()) }

    single { DbFactory.makeAppDatabase(get()) }

    factory { get<MovieReelDatabase>().getMovieNowPlayingDao() }

    factory { get<MovieReelDatabase>().getMoviePopularDao() }

    factory { get<MovieReelDatabase>().getMovieTopRatedDao() }

    factory { get<MovieReelDatabase>().getMovieUpcomingDao() }
}

val activitiesModules = module {
    single { SplashPresenterImpl<SplashView>(get()) }

    single<SplashPresenter<SplashView>> { SplashPresenterImpl(get()) }

    single { MainPresenterImpl<MainView>() }

    single<MainPresenter<MainView>> { MainPresenterImpl() }

    single { MoviesPresenterImpl<MovieFragView>() }

    single<MoviesPresenter<MovieFragView>> { MoviesPresenterImpl() }

    single { NowPlayingAdapter(ArrayList()) }

    single { NowPlayingViewMapper() }

//    @Provides
//    @PerActivity
//    fun provideMoviePresenter(movieFragPresenter: MoviesPresenterImpl<MovieFragView>): MoviesPresenter<MovieFragView> {
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

}