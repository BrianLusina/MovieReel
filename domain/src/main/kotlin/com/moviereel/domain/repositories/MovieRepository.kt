package com.moviereel.domain.repositories

import com.moviereel.domain.models.movies.*
import io.reactivex.Flowable

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface MovieRepository {

    fun getMoviesNowPlaying(page : Int, language: String) : Flowable<List<MovieNowPlayingModel>>

    fun getMoviesLatest(language: String) : Flowable<MovieLatestModel>

    fun getMoviesPopular(page : Int, language: String) : Flowable<List<MoviePopularModel>>

    fun getMoviesTopRated(page : Int, language: String, region: String) : Flowable<List<MovieTopRatedModel>>

    fun getMoviesUpcoming(page : Int, language: String, region: String) : Flowable<List<MovieUpcomingModel>>
}
