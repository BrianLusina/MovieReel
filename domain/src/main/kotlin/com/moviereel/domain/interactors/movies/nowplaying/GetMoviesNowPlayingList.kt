package com.moviereel.domain.interactors.movies.nowplaying

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.moviereel.domain.interactors.SingleUseCase
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import com.moviereel.domain.repositories.MoviesRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 26/04/18.
 * @Notes Use Case used to retrieve a list of [MovieNowPlayingModel] instances from [MoviesRepository]
 */
open class GetMoviesNowPlayingList
@Inject
constructor(val moviesRespository: MoviesRepository,
            threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) :
        SingleUseCase<List<MovieNowPlayingModel>, GetMoviesNowPlayingList.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: Params?): Single<List<MovieNowPlayingModel>> {
        if(params != null){
            val moviesNowPlayingFlowable = params.let { moviesRespository.getMoviesNowPlayingList(it.page, it.language) }
            return moviesNowPlayingFlowable.singleOrError()
        }
        val moviesNowPlayingFlowable = params?.let { moviesRespository.getMoviesNowPlayingList(it.page, it.language) }
        return moviesNowPlayingFlowable?.singleOrError()!!
    }

    class Params constructor(var page: Int, var language: String) {
        companion object {
            fun forMovies(page: Int, language: String): Params {
                return Params(page, language)
            }
        }
    }
}