package com.moviereel.remote.mapper.movies

import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.remote.mapper.EntityMapper
import com.moviereel.remote.models.movie.MovieNowPlayingApiResponse
import javax.inject.Inject

/**
 * @author lusinabrian on 28/05/18.
 * @Notes Responsible for mapping Response data from API to Entity data when moving from this layer to data layer
 */
open class MovieNowPlayingRemoteMapper @Inject constructor() : EntityMapper<MovieNowPlayingApiResponse, MovieNowPlayingDataEntity> {

    /**
     * Map an instance of [MovieNowPlayingApiResponse] to [MovieNowPlayingDataEntity]
     * @return [MovieNowPlayingDataEntity]
     */
    override fun mapResponseFromRemote(type: MovieNowPlayingApiResponse): MovieNowPlayingDataEntity {
        return MovieNowPlayingDataEntity(type.id, type.voteCount, type.video, type.voteAverage, type.title,
                type.popularity, type.posterPath, type.originalLang, type.originalTitle, type.genreIds,
                type.backdropPath, type.adult, type.overview, type.releaseDate)
    }

    /**
     * Map a list of [MovieNowPlayingApiResponse] to a collection of [MovieNowPlayingDataEntity]
     * @return [Collection]
     */
    override fun mapResponseListFromRemote(type: Collection<MovieNowPlayingApiResponse>): Collection<MovieNowPlayingDataEntity> {
        return type.map { mapResponseFromRemote(it) }
    }
}