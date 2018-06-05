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
 * @Notes Use Case used to retrieve details of a [MovieNowPlayingModel] instance from [MoviesDomainRepository]
 */
open class GetMoviesNPDetails
@Inject
constructor(private val moviesDomainRepository: MoviesDomainRepository,
            threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) :
        SingleUseCase<MovieNowPlayingDomainModel, GetMoviesNPDetails.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: Params?): Single<MovieNowPlayingDomainModel> {
        val movieNowPlayingObservable = params?.let { moviesDomainRepository.getMovieNowPlaying(it.id) }
        return movieNowPlayingObservable?.singleOrError()!!
    }

    class Params private constructor(var id: Long) {
        companion object {
            fun forMovies(id: Long): Params {
                return Params(id)
            }
        }
    }
}