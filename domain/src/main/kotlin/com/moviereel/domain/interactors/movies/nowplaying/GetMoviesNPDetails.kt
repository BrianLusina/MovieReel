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
 * @Notes Use Case used to retrieve details of a [MovieNowPlayingModel] instance from [MoviesRepository]
 */
open class GetMoviesNPDetails
@Inject
constructor(private val moviesRepository: MoviesRepository,
            threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) :
        ObservableUseCase<MovieNowPlayingModel, GetMoviesNPDetails.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<MovieNowPlayingModel> {
        val movieNowPlayingObservable = params?.id?.let { moviesRepository.getMovieNowPlaying(it) }
        return movieNowPlayingObservable?.toObservable()!!
    }

    inner class Params private constructor(var id: Int) {
        fun forMovies(id: Int): Params {
            return Params(id)
        }
    }
}