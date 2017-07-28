package com.moviereel.data.db

import com.moviereel.data.db.models.movie.DaoMaster
import com.moviereel.data.db.models.movie.DaoSession
import com.moviereel.data.db.models.movie.MovieLatestModel
import com.moviereel.data.db.models.movie.MovieNowPlayingModel
import com.moviereel.data.db.models.movie.MoviePopularModel
import com.moviereel.data.db.models.movie.MovieTopRatedModel

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable

/**
 * @author lusinabrian on 28/03/17
 * * Implementation of [DbHelper]
 */

@Singleton
class DbHelperImpl @Inject
internal constructor(dbOpenHelper: DbOpenHelper) : DbHelper {

    private val mDaoSession: DaoSession = DaoMaster(dbOpenHelper.writableDb).newSession()

    override fun insertMovieNowPlayingItem(movieNowPlayingModel: MovieNowPlayingModel): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.movieNowPlayingModelDao.insert(movieNowPlayingModel)
            true
        }
    }

    override fun insertMovieNowPlayingItemList(movieNowPlayingModels: List<MovieNowPlayingModel>): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.movieNowPlayingModelDao.insertInTx(movieNowPlayingModels)
            true
        }
    }

    override fun insertMovieLatestItem(movieLatestModel: MovieLatestModel): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.movieLatestModelDao.insertInTx(movieLatestModel)
            true
        }
    }

    override fun insertMoviePopularItem(moviePopularModel: MoviePopularModel): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.moviePopularModelDao.insert(moviePopularModel)
            true
        }
    }

    override fun insertMoviePopularItemList(moviePopularModels: List<MoviePopularModel>): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.moviePopularModelDao.insertInTx(moviePopularModels)
            true
        }
    }

    override fun insertMovieTopRatedItem(movieTopRatedModel: MovieTopRatedModel): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.movieTopRatedModelDao.insert(movieTopRatedModel)
            true
        }
    }

    override fun insertMovieTopRatedItemList(movieTopRatedModels: List<MovieTopRatedModel>): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.movieTopRatedModelDao.insertInTx(movieTopRatedModels)
            true
        }
    }

    override fun getNowPlayingMovieItem(movieNowPlayingId: Long): Observable<MovieNowPlayingModel> {
        return Observable.fromCallable { mDaoSession.movieNowPlayingModelDao.loadByRowId(movieNowPlayingId) }
    }

    override val movieNowPlayingItems: Observable<List<MovieNowPlayingModel>>
        get() = Observable.fromCallable { mDaoSession.movieNowPlayingModelDao.loadAll() }

    override fun getMovieLatestItem(movieLatestModelId: Long): Observable<MovieLatestModel> {
        return Observable.fromCallable { mDaoSession.movieLatestModelDao.loadByRowId(movieLatestModelId) }
    }

    override fun getMoviePopularItem(moviePopularId: Long): Observable<MoviePopularModel> {
        return Observable.fromCallable { mDaoSession.moviePopularModelDao.loadByRowId(moviePopularId) }
    }

    override val moviePopularItemList: Observable<List<MoviePopularModel>>
        get() = Observable.fromCallable { mDaoSession.moviePopularModelDao.loadAll() }

    override fun getMovieTopRatedItem(movieTopRatedId: Long): Observable<MovieTopRatedModel> {
        return Observable.fromCallable { mDaoSession.movieTopRatedModelDao.loadByRowId(movieTopRatedId) }
    }

    override val movieTopRatedItemList: Observable<List<MovieTopRatedModel>>
        get() = Observable.fromCallable { mDaoSession.movieTopRatedModelDao.loadAll() }

    override fun updateNowPlayingMovieItem(movieNowPlayingModel: MovieNowPlayingModel): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.movieNowPlayingModelDao.update(movieNowPlayingModel)
            true
        }
    }

    override fun updateMovieLatestItem(movieLatestModel: MovieLatestModel): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.movieLatestModelDao.update(movieLatestModel)
            true
        }
    }

    override fun updateMoviePopularItem(moviePopularModel: MoviePopularModel): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.moviePopularModelDao.update(moviePopularModel)
            true
        }
    }

    override fun updateMovieTopRatedItem(movieTopRatedModel: MovieTopRatedModel): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.movieTopRatedModelDao.update(movieTopRatedModel)
            true
        }
    }

    override fun deleteNowPlayingMovieItem(movieNowPlayingId: Long): Observable<Long> {
        return Observable.fromCallable {
            // mDaoSession.movieNowPlayingModelDao.deleteByKey(movieNowPlayingId)
            movieNowPlayingId
        }
    }

    override fun deleteMovieNowPlayingItems(movieNowPlayingModels: List<MovieNowPlayingModel>): Observable<Int> {
        return Observable.fromCallable {
            mDaoSession.movieNowPlayingModelDao.deleteInTx(movieNowPlayingModels)
            movieNowPlayingModels.size
        }
    }

    override fun deleteMovieLatestItem(movieLatestId: Long): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.movieLatestModelDao.deleteByKey(movieLatestId)
            true
        }
    }

    override fun deleteMoviePopularItem(moviePopularId: Long): Observable<Long> {
        return Observable.fromCallable {
            mDaoSession.moviePopularModelDao.deleteByKey(moviePopularId)
            moviePopularId
        }
    }

    override fun deleteMoviePopularItemList(moviePopularModels: List<MoviePopularModel>): Observable<Int> {
        return Observable.fromCallable {
            mDaoSession.moviePopularModelDao.deleteInTx(moviePopularModels)
            moviePopularModels.size
        }
    }

    override fun deleteMovieTopRatedItem(movieTopRatedId: Long): Observable<Long> {
        return Observable.fromCallable {
            mDaoSession.movieTopRatedModelDao.deleteByKey(movieTopRatedId)
            movieTopRatedId
        }
    }

    override fun deleteMovieTopRatedItemList(movieTopRatedModels: List<MovieTopRatedModel>): Observable<Int> {
        return Observable.fromCallable {
            mDaoSession.movieTopRatedModelDao.deleteInTx(movieTopRatedModels)
            movieTopRatedModels.size
        }
    }
}
