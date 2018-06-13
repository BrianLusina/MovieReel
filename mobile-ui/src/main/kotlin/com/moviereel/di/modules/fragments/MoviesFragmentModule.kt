package com.moviereel.di.modules.fragments

import com.moviereel.di.components.fragments.MoviesFragmentSubComponent
import com.moviereel.di.scopes.PerActivity
import com.moviereel.presentation.view.entertain.movie.MoviesPresenter
import com.moviereel.presentation.view.entertain.movie.MoviesPresenterImpl
import com.moviereel.presentation.view.entertain.movie.MovieFragView
import dagger.Module
import dagger.Provides


@Module(subcomponents = [MoviesFragmentSubComponent::class])
class MoviesFragmentModule {

    @Provides
    @PerActivity
    fun provideMoviesPresenter(moviesPresenter: MoviesPresenterImpl<MovieFragView>) : MoviesPresenter<MovieFragView> {
        return moviesPresenter
    }

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