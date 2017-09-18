package com.moviereel.data.repositories.movierepo

import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.api.model.movie.response.MovieNPResponse
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.data.db.entities.movie.MoviePEntity
import com.moviereel.data.db.entities.movie.MovieTREntity
import io.reactivex.Flowable
import io.reactivex.Observable
import org.jetbrains.anko.AnkoLogger

/**
 * @author lusinabrian on 08/08/17.
 * @Notes Common methods that will be used for the repositories will be found here.
 * This will enable a greater deal of abstraction and as well as remove DRY principle(s)
 */
interface MovieDataSource : AnkoLogger {

    override val loggerTag: String
        get() = super.loggerTag

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently
     * now playing
     * @param remote whether to fetch this from a remote repo or not
     * @return [MovieNPResponse] response to return from the api call
     * */
    fun getMoviesNowPlaying(remote: Boolean? = true, page: Int, language: String): Flowable<List<MovieNPEntity>>

    /**
     * API call to get the latest movies being shown
     * @param remote whether to fetch this from a remote repo or not
     * */
    fun doGetMoviesLatest(remote: Boolean = true, language: String): Observable<BaseResultsResponse.MovieLatestResponse>

    /**
     * Does an api call to get a list of popular movies
     * @param remote whether to fetch this from a remote repo or not
     * @return A list of [MoviePEntity] we get from the api call
     */
    fun doGetMoviesPopular(remote: Boolean = true, page: Int, language: String): Flowable<List<MoviePEntity>>

    /**
     * Gets top rated movies
     * @param remote whether the data will come from a remote source
     * @param page the page of the data
     * @param language the language to query from the data source
     * @param region the region to get this data from
     * */
    fun doGetMoviesTopRated(remote: Boolean = true, page: Int, language: String, region : String): Flowable<List<MovieTREntity>>
}