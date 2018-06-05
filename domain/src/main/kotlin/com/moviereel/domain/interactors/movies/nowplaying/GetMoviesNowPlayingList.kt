package com.moviereel.domain.interactors.movies.nowplaying

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.moviereel.domain.interactors.SingleUseCase
import com.moviereel.domain.models.movies.MovieNowPlayingDomainModel
import com.moviereel.domain.repositories.MoviesDomainRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 26/04/18.
 * @Notes Use Case used to retrieve a list of [MovieNowPlayingModel] instances from [MoviesDomainRepository]
 */
open class GetMoviesNowPlayingList
@Inject
constructor(val moviesDomainRespository: MoviesDomainRepository,
            threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) :
        SingleUseCase<List<MovieNowPlayingDomainModel>, GetMoviesNowPlayingList.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: Params?): Single<List<MovieNowPlayingDomainModel>> {
        if(params != null){
            val moviesNowPlayingFlowable = params.let { moviesDomainRespository.getMoviesNowPlayingList(it.page, it.language) }
            return moviesNowPlayingFlowable.singleOrError()
        }
        val moviesNowPlayingFlowable = moviesDomainRespository.getMoviesNowPlayingList()
        return moviesNowPlayingFlowable.singleOrError()
    }

    class Params constructor(var page: Int, var language: String) {
        companion object {
            fun forMovies(page: Int, language: String): Params {
                return Params(page, language)
            }
        }
    }
}