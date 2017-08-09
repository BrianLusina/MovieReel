package com.moviereel.data.repositories.movierepo.local

import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.api.model.movie.response.MovieNPResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import com.moviereel.data.db.dao.MovieNPDao
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.data.repositories.movierepo.MovieDataSource
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
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
constructor(
        val moviesNPDao: MovieNPDao) : MovieDataSource, AnkoLogger {

    override val loggerTag: String
        get() = super.loggerTag

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently now playing
     * @return [MovieNPResponse] response to return from the api call
     */
    override fun getMoviesNowPlaying(remote: Boolean, page: Int, language: String): Flowable<List<MovieNPEntity>> {
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

    /**
     * API call to get the latest movies being shown*/
    override fun doGetMoviesLatest(remote: Boolean, language: String): Observable<BaseResultsResponse.MovieLatestResponse> {
        // return moviesNPDao.getMoviesLatest(language)
        return null!!
    }

    /**
     * Does an api call to get a list of popular movies
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    override fun doGetMoviesPopular(remote: Boolean, page: Int, language: String): Observable<MoviePopularResponse> {
        //return moviesNPDao.getMoviesPopular(page, language)
        return null!!
    }

/*    override fun insertMovieNowPlayingItem(movieNPEntity: MovieNPEntity): Observable<Boolean> {
    return mDbHelper.insertMovieNowPlayingItem(movieNPEntity)
}

override fun insertMovieNowPlayingItemList(movieNPEntities: List<MovieNPEntity>): Observable<Boolean> {
    return mDbHelper.insertMovieNowPlayingItemList(movieNPEntities)
}

override fun insertMovieLatestItem(movieLatestEntity: MovieLatestEntity): Observable<Boolean> {
    return mDbHelper.insertMovieLatestItem(movieLatestEntity)
}

override fun insertMoviePopularItem(moviePEntity: MoviePEntity): Observable<Boolean> {
    return mDbHelper.insertMoviePopularItem(moviePEntity)
}

override fun insertMoviePopularItemList(moviePEntities: List<MoviePEntity>): Observable<Boolean> {
    return mDbHelper.insertMoviePopularItemList(moviePEntities)
}

override fun insertMovieTopRatedItem(movieTREntity: MovieTREntity): Observable<Boolean> {
    return mDbHelper.insertMovieTopRatedItem(movieTREntity)
}

override fun insertMovieTopRatedItemList(movieTREntities: List<MovieTREntity>): Observable<Boolean> {
    return mDbHelper.insertMovieTopRatedItemList(movieTREntities)
}

override fun getNowPlayingMovieItem(movieNowPlayingId: Long): Observable<MovieNPEntity> {
    return mDbHelper.getNowPlayingMovieItem(movieNowPlayingId)
}

override val movieNPItems: Observable<List<MovieNPEntity>>
    get() = mDbHelper.movieNPItems

override fun getMovieLatestItem(movieLatestModelId: Long): Observable<MovieLatestEntity> {
    return mDbHelper.getMovieLatestItem(movieLatestModelId)
}

override fun getMoviePopularItem(moviePopularId: Long): Observable<MoviePEntity> {
    return mDbHelper.getMoviePopularItem(moviePopularId)
}

override val moviePItemList: Observable<List<MoviePEntity>>
    get() = mDbHelper.moviePItemList

override fun getMovieTopRatedItem(movieTopRatedId: Long): Observable<MovieTREntity> {
    return mDbHelper.getMovieTopRatedItem(movieTopRatedId)
}

override val movieTRItemList: Observable<List<MovieTREntity>>
    get() = mDbHelper.movieTRItemList

override fun updateNowPlayingMovieItem(movieNPEntity: MovieNPEntity): Observable<Boolean> {
    return mDbHelper.updateNowPlayingMovieItem(movieNPEntity)
}

override fun updateMovieLatestItem(movieLatestEntity: MovieLatestEntity): Observable<Boolean> {
    return mDbHelper.updateMovieLatestItem(movieLatestEntity)
}

override fun updateMoviePopularItem(moviePEntity: MoviePEntity): Observable<Boolean> {
    return mDbHelper.updateMoviePopularItem(moviePEntity)
}

override fun updateMovieTopRatedItem(movieTREntity: MovieTREntity): Observable<Boolean> {
    return mDbHelper.updateMovieTopRatedItem(movieTREntity)
}

override fun deleteNowPlayingMovieItem(movieNowPlayingId: Long): Observable<Long> {
    return mDbHelper.deleteNowPlayingMovieItem(movieNowPlayingId)
}

override fun deleteMovieNowPlayingItems(movieNPEntities: List<MovieNPEntity>): Observable<Int> {
    return mDbHelper.deleteMovieNowPlayingItems(movieNPEntities)
}

override fun deleteMovieLatestItem(movieLatestId: Long): Observable<Boolean> {
    return mDbHelper.deleteMovieLatestItem(movieLatestId)
}

override fun deleteMoviePopularItem(moviePopularId: Long): Observable<Long> {
    return mDbHelper.deleteMoviePopularItem(moviePopularId)
}

override fun deleteMoviePopularItemList(moviePEntities: List<MoviePEntity>): Observable<Int> {
    return mDbHelper.deleteMoviePopularItemList(moviePEntities)
}

override fun deleteMovieTopRatedItem(movieTopRatedId: Long): Observable<Long> {
    return mDbHelper.deleteMovieTopRatedItem(movieTopRatedId)
}

override fun deleteMovieTopRatedItemList(movieTREntities: List<MovieTREntity>): Observable<Int> {
    return mDbHelper.deleteMovieTopRatedItemList(movieTREntities)
}*/

}