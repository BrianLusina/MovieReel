package com.moviereel.remote

import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.data.source.movies.repo.MovieRemote
import com.moviereel.remote.api.ApiService
import com.moviereel.remote.mapper.movies.MovieNowPlayingRemoteMapper
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 28/05/18.
 * @Notes Remote implementation for retrieving Movie instances. This class implements the
 * [MovieRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class MovieRemoteImpl @Inject constructor(private val apiService: ApiService,
                                          private val movieNowPlayingRemoteMapper: MovieNowPlayingRemoteMapper)
    : MovieRemote {

    override fun getMoviesNowPlaying(page: Int, language: String): Single<List<MovieNowPlayingDataEntity>> {
        return apiService.getMoviesNowPlaying(language, page)
                .map { movieNowPlayingRemoteMapper.mapResponseListFromRemote(it).toList() }
    }
}