package com.moviereel.data.db

import com.moviereel.data.db.dao.MovieNPDao
import com.moviereel.data.db.entities.movie.MovieLatestEntity
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.data.db.entities.movie.MoviePEntity
import com.moviereel.data.db.entities.movie.MovieTREntity
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 28/03/17
 * * Implementation of [DbHelper]
 */

@Singleton
class DbHelperImpl
@Inject
constructor(val movieNpDao: MovieNPDao) : DbHelper {

    override fun insertMovieNowPlayingItem(movieNPEntity: MovieNPEntity): Observable<Boolean> {
        return Observable.fromCallable {
            // movieNpDao.insertMovieNp(movieNPEntity)
            true
        }
    }

    override fun insertMovieNowPlayingItemList(movieNPEntities: List<MovieNPEntity>): Observable<Boolean> {
        return Observable.fromCallable {
            // // movieNpDao.movieNowPlayingModelDao.insertInTx(movieNPEntities)
            true
        }
    }

    override fun insertMovieLatestItem(movieLatestEntity: MovieLatestEntity): Observable<Boolean> {
        return Observable.fromCallable {
            // // movieNpDao.movieLatestModelDao.insertInTx(movieLatestEntity)
            true
        }
    }

    override fun insertMoviePopularItem(moviePEntity: MoviePEntity): Observable<Boolean> {
        return Observable.fromCallable {
            // // movieNpDao.moviePopularModelDao.insert(moviePEntity)
            true
        }
    }

    override fun insertMoviePopularItemList(moviePEntities: List<MoviePEntity>): Observable<Boolean> {
        return Observable.fromCallable {
            // movieNpDao.moviePopularModelDao.insertInTx(moviePEntities)
            true
        }
    }

    override fun insertMovieTopRatedItem(movieTREntity: MovieTREntity): Observable<Boolean> {
        return Observable.fromCallable {
            // movieNpDao.movieTopRatedModelDao.insert(movieTREntity)
            true
        }
    }

    override fun insertMovieTopRatedItemList(movieTREntities: List<MovieTREntity>): Observable<Boolean> {
        return Observable.fromCallable {
            // movieNpDao.movieTopRatedModelDao.insertInTx(movieTREntities)
            true
        }
    }

    override fun getNowPlayingMovieItem(movieNowPlayingId: Long): Observable<MovieNPEntity> {
        return Observable.fromCallable {
            // movieNpDao.movieNowPlayingModelDao.loadByRowId(movieNowPlayingId)
            null
        }
    }

    override val movieNPItems: Observable<List<MovieNPEntity>>
        get() = Observable.fromCallable {
            // movieNpDao.movieNowPlayingModelDao.loadAll() }
            null
        }

    override fun getMovieLatestItem(movieLatestModelId: Long): Observable<MovieLatestEntity> {
        return Observable.fromCallable {
            // movieNpDao.movieLatestModelDao.loadByRowId(movieLatestModelId)
            null
        }
    }

    override fun getMoviePopularItem(moviePopularId: Long): Observable<MoviePEntity> {
        return Observable.fromCallable {
            // movieNpDao.moviePopularModelDao.loadByRowId(moviePopularId)
            null
        }
    }

    override val moviePItemList: Observable<List<MoviePEntity>>
        get() = Observable.fromCallable {
            // movieNpDao.moviePopularModelDao.loadAll() }
            null
        }

    override fun getMovieTopRatedItem(movieTopRatedId: Long): Observable<MovieTREntity> {
        return Observable.fromCallable {
            // movieNpDao.movieTopRatedModelDao.loadByRowId(movieTopRatedId) }
            null
        }
    }

    override val movieTRItemList: Observable<List<MovieTREntity>>
        get() = Observable.fromCallable {
            // movieNpDao.movieTopRatedModelDao.loadAll() }
            null
        }

    override fun updateNowPlayingMovieItem(movieNPEntity: MovieNPEntity): Observable<Boolean> {
        return Observable.fromCallable {
            // movieNpDao.movieNowPlayingModelDao.update(movieNPEntity)
            true
        }
    }

    override fun updateMovieLatestItem(movieLatestEntity: MovieLatestEntity): Observable<Boolean> {
        return Observable.fromCallable {
            // movieNpDao.movieLatestModelDao.update(movieLatestEntity)
            true
        }
    }

    override fun updateMoviePopularItem(moviePEntity: MoviePEntity): Observable<Boolean> {
        return Observable.fromCallable {
            // movieNpDao.moviePopularModelDao.update(moviePEntity)
            true
        }
    }

    override fun updateMovieTopRatedItem(movieTREntity: MovieTREntity): Observable<Boolean> {
        return Observable.fromCallable {
            // movieNpDao.movieTopRatedModelDao.update(movieTREntity)
            true
        }
    }

    override fun deleteNowPlayingMovieItem(movieNowPlayingId: Long): Observable<Long> {
        return Observable.fromCallable {
            // // movieNpDao.movieNowPlayingModelDao.deleteByKey(movieNowPlayingId)
            movieNowPlayingId
        }
    }

    override fun deleteMovieNowPlayingItems(movieNPEntities: List<MovieNPEntity>): Observable<Int> {
        return Observable.fromCallable {
            // movieNpDao.movieNowPlayingModelDao.deleteInTx(movieNPEntities)
            movieNPEntities.size
        }
    }

    override fun deleteMovieLatestItem(movieLatestId: Long): Observable<Boolean> {
        return Observable.fromCallable {
            // movieNpDao.movieLatestModelDao.deleteByKey(movieLatestId)
            true
        }
    }

    override fun deleteMoviePopularItem(moviePopularId: Long): Observable<Long> {
        return Observable.fromCallable {
            // movieNpDao.moviePopularModelDao.deleteByKey(moviePopularId)
            moviePopularId
        }
    }

    override fun deleteMoviePopularItemList(moviePEntities: List<MoviePEntity>): Observable<Int> {
        return Observable.fromCallable {
            // movieNpDao.moviePopularModelDao.deleteInTx(moviePEntities)
            moviePEntities.size
        }
    }

    override fun deleteMovieTopRatedItem(movieTopRatedId: Long): Observable<Long> {
        return Observable.fromCallable {
            // movieNpDao.movieTopRatedModelDao.deleteByKey(movieTopRatedId)
            movieTopRatedId
        }
    }

    override fun deleteMovieTopRatedItemList(movieTREntities: List<MovieTREntity>): Observable<Int> {
        return Observable.fromCallable {
            // movieNpDao.movieTopRatedModelDao.deleteInTx(movieTREntities)
            movieTREntities.size
        }
    }
}
