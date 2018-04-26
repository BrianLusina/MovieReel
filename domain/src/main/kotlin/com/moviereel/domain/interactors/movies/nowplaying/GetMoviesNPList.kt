package com.moviereel.domain.interactors.movies.nowplaying

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.moviereel.domain.interactors.ObservableUseCase
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import com.moviereel.domain.repositories.MoviesRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author lusinabrian on 26/04/18.
 * @Notes Use Case used to retrieve a list of [MovieNowPlayingModel] instances from [MoviesRepository]
 */
open class GetMoviesNPList
@Inject
constructor(val moviesRespository: MoviesRepository,
            threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) :
        ObservableUseCase<List<MovieNowPlayingModel>, GetMoviesNPList.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<List<MovieNowPlayingModel>> {
        val moviesNowPlayingFlowable = params?.let { moviesRespository.getMoviesNowPlayingList(it.page, it.language) }
        return moviesNowPlayingFlowable?.toObservable()!!
    }

    class Params private constructor(var page: Int, var language: String) {
        companion object {
            fun forMovies(page: Int, language: String): Params {
                return Params(page, language)
            }
        }
    }
}