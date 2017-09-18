package com.moviereel.data.repositories

import com.moviereel.data.api.model.movie.MovieNowPlayingResponse
import com.moviereel.data.api.model.movie.MoviePopularResponse
import com.moviereel.data.db.entities.movie.MovieLatestEntity
import com.moviereel.data.db.entities.movie.MovieNowPlayingEntity
import com.moviereel.data.db.entities.movie.MoviePopularEntity
import com.moviereel.data.db.entities.movie.MovieTopRatedEntity
import com.moviereel.data.repositories.movierepo.MoviesRepoHelper
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @author lusinabrian on 08/08/17.
 * @Notes Repository implementation
 */
class RepositoryHelperImpl
@Inject
constructor(
        val moviesRepo: MoviesRepoHelper
) : RepositoryHelper {

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently now playing
     * @return [MovieNowPlayingResponse] response to return from the api call
     */
    override fun getMoviesNowPlaying(remote: Boolean?, page: Int, language: String): Flowable<List<MovieNowPlayingEntity>> {
        return moviesRepo.getMoviesNowPlaying(remote, page, language)
    }

    /**
     * API call to get the latest movies being shown*/
    override fun doGetMoviesLatest(remote: Boolean, language: String): Flowable<MovieLatestEntity> {
        return moviesRepo.doGetMoviesLatest(remote, language)
    }

    /**
     * Does an api call to get a list of popular movies
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    override fun doGetMoviesPopular(remote: Boolean, page: Int, language: String): Flowable<List<MoviePopularEntity>> {
        return moviesRepo.doGetMoviesPopular(remote, page, language)
    }

    override fun doGetMoviesTopRated(remote: Boolean, page: Int, language: String, region: String): Flowable<List<MovieTopRatedEntity>> {
        return moviesRepo.doGetMoviesTopRated(remote, page, language, region)
    }
}