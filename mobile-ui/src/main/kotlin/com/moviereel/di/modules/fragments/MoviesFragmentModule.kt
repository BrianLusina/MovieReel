package com.moviereel.di.modules.fragments

import android.support.v7.app.AppCompatActivity
import com.moviereel.di.components.fragments.MoviesFragmentSubComponent
import com.moviereel.di.scopes.PerActivity
import com.moviereel.mapper.movies.NowPlayingViewMapper
import com.moviereel.presentation.view.entertain.movie.MovieFragView
import com.moviereel.presentation.view.entertain.movie.MoviesPresenter
import com.moviereel.presentation.view.entertain.movie.MoviesPresenterImpl
import com.moviereel.ui.entertain.movie.MoviesViewPagerAdapter
import com.moviereel.ui.entertain.movie.nowplaying.NowPlayingAdapter
import dagger.Module
import dagger.Provides


@Module(subcomponents = [MoviesFragmentSubComponent::class])
class MoviesFragmentModule {

    @Provides
    @PerActivity
    fun provideMoviesPresenter(moviesPresenter: MoviesPresenterImpl<MovieFragView>) : MoviesPresenter<MovieFragView> {
        return moviesPresenter
    }

    @Provides
    fun provideMovieViewPagerAdapter(): MoviesViewPagerAdapter {
        val activity = AppCompatActivity()
        return MoviesViewPagerAdapter(activity.supportFragmentManager)
    }

    @Provides
    fun provideNowPlayingAdapter(): NowPlayingAdapter {
        return NowPlayingAdapter(ArrayList())
    }

    @Provides
    fun provideNowPlayingMapper() : NowPlayingViewMapper {
        return NowPlayingViewMapper()
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