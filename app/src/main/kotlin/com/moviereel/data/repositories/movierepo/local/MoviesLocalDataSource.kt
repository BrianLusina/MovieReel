package com.moviereel.data.repositories.movierepo.local

import com.moviereel.data.api.model.movie.MovieNowPlayingResponse
import com.moviereel.data.api.model.movie.MoviePopularResponse
import com.moviereel.data.db.dao.MovieNPDao
import com.moviereel.data.db.dao.MoviePopularDao
import com.moviereel.data.db.dao.MovieTRDao
import com.moviereel.data.db.entities.movie.MovieLatestEntity
import com.moviereel.data.db.entities.movie.MovieNowPlayingEntity
import com.moviereel.data.db.entities.movie.MoviePopularEntity
import com.moviereel.data.db.entities.movie.MovieTopRatedEntity
import com.moviereel.data.repositories.movierepo.MovieDataSource
import io.reactivex.Flowable
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
     * @return [MovieNowPlayingResponse] response to return from the api call
     */
    override fun getMoviesNowPlaying(remote: Boolean?, page: Int, language: String): Flowable<List<MovieNowPlayingEntity>> {
        return moviesNPDao.getAllMoviesNowPlaying()
    }

    /**
     * Saves movies now playing for offline access
     * */
    fun saveMoviesNowPlayingOffline(movieNowPlayingData: Flowable<List<MovieNowPlayingEntity>>) {
        movieNowPlayingData
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
    override fun doGetMoviesPopular(remote: Boolean, page: Int, language: String): Flowable<List<MoviePopularEntity>> {
        return moviePopularDao.getAllMoviesPopular()
    }

    /**
     * Saves popular movies to database
     * */
    fun savePopularMoviesToDb(moviePopularData: Flowable<List<MoviePopularEntity>>) {
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
    override fun doGetMoviesTopRated(remote: Boolean, page: Int, language: String, region: String): Flowable<List<MovieTopRatedEntity>> {
        return movieTopRatedDao.getAllMoviesTopRated()
    }

    /**
     * Saves popular movies to database
     * */
    fun saveTopRatedMoviesToDb(movieTopRatedData: Flowable<List<MovieTopRatedEntity>>) {
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
    override fun doGetMoviesLatest(remote: Boolean, language: String): Flowable<MovieLatestEntity> {
        // return moviesNPDao.getMoviesLatest(language)
        return null!!
    }
}