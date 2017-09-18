package com.moviereel.data.repositories.movierepo.local

import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.api.model.movie.response.MovieNPResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import com.moviereel.data.db.dao.MovieNPDao
import com.moviereel.data.db.dao.MoviePopularDao
import com.moviereel.data.db.dao.MovieTRDao
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.data.db.entities.movie.MoviePEntity
import com.moviereel.data.db.entities.movie.MovieTREntity
import com.moviereel.data.repositories.movierepo.MovieDataSource
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.error
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 08/08/17.
 * @Notes Local Data source for movie data
 */
@Singleton
class MoviesLocalDataSource
@Inject
constructor(val moviesNPDao: MovieNPDao,
            val moviePopularDao: MoviePopularDao,
            val movieTopRatedDao: MovieTRDao) : MovieDataSource {

    // ************************ NOW PLAYING MOVIES **************************************************
    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently now playing
     * @return [MovieNPResponse] response to return from the api call
     */
    override fun getMoviesNowPlaying(remote: Boolean?, page: Int, language: String): Flowable<List<MovieNPEntity>> {
        return moviesNPDao.getAllMoviesNowPlaying()
    }

    /**
     * Saves movies now playing for offline access
     * */
    fun saveMoviesNowPlayingOffline(movieNpData: Flowable<List<MovieNPEntity>>) {
        movieNpData
                .subscribeOn(Schedulers.newThread())
                .subscribe({
                    it.forEach {
                        moviesNPDao.insertMovieNpList(it)
                    }
                }) {
                    // consume error
                    error("Error saving to database ${it.message}", it)
                }
    }

    // ************************ POPULAR MOVIES **************************************************
    /**
     * Does an api call to get a list of popular movies
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    override fun doGetMoviesPopular(remote: Boolean, page: Int, language: String): Flowable<List<MoviePEntity>> {
        return moviePopularDao.getAllMoviesPopular()
    }

    /**
     * Saves popular movies to database
     * */
    fun savePopularMoviesToDb(moviePopularData: Flowable<List<MoviePEntity>>) {
        moviePopularData.subscribeOn(Schedulers.newThread())
                .subscribe({
                    it.forEach {
                        moviePopularDao.insertMoviePopular(it)
                    }
                }, {
                    // error
                    error("Error encountered saving popular movies ${it.message}", it)
                })
    }

    // ************************ TOP RATED MOVIES **************************************************
    override fun doGetMoviesTopRated(remote: Boolean, page: Int, language: String, region: String): Flowable<List<MovieTREntity>> {
        return movieTopRatedDao.getAllMoviesTopRated()
    }

    /**
     * Saves popular movies to database
     * */
    fun saveTopRatedMoviesToDb(movieTopRatedData: Flowable<List<MovieTREntity>>) {
        movieTopRatedData
                .subscribeOn(Schedulers.newThread())
                .subscribe({
                    it.forEach {
                        movieTopRatedDao.insertMovieTopRated(it)
                    }
                }, {
                    // error
                    error("Error encountered saving popular movies ${it.message}", it)
                })
    }

    // ************************ LATEST MOVIES **************************************************

    /**
     * API call to get the latest movies being shown*/
    override fun doGetMoviesLatest(remote: Boolean, language: String): Observable<BaseResultsResponse.MovieLatestResponse> {
        // return moviesNPDao.getMoviesLatest(language)
        return null!!
    }
}