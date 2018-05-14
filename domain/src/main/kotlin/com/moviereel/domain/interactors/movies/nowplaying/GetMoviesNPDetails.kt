package com.moviereel.domain.interactors.movies.nowplaying

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.moviereel.domain.interactors.ObservableUseCase
import com.moviereel.domain.interactors.SingleUseCase
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import com.moviereel.domain.repositories.MoviesRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 26/04/18.
 * @Notes Use Case used to retrieve details of a [MovieNowPlayingModel] instance from [MoviesRepository]
 */
open class GetMoviesNPDetails
@Inject
constructor(private val moviesRepository: MoviesRepository,
            threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) :
        SingleUseCase<MovieNowPlayingModel, GetMoviesNPDetails.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: Params?): Single<MovieNowPlayingModel> {
        val movieNowPlayingObservable = params?.let { moviesRepository.getMovieNowPlaying(it.id) }
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