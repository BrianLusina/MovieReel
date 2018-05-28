package com.moviereel.remote.mapper.movies

import com.moviereel.data.models.movies.MovieNowPlayingEntity
import com.moviereel.remote.mapper.EntityMapper
import com.moviereel.remote.models.movie.MovieNowPlayingResponse
import javax.inject.Inject

/**
 * @author lusinabrian on 28/05/18.
 * @Notes Responsible for mapping Response data from API to Entity data when moving from this layer to data layer
 */
open class MovieNowPlayingMapper @Inject constructor() : EntityMapper<MovieNowPlayingResponse, MovieNowPlayingEntity> {

    /**
     * Map an instance of [MovieNowPlayingResponse] to [MovieNowPlayingEntity]
     * @return [MovieNowPlayingEntity]
     */
    override fun mapResponseFromRemote(type: MovieNowPlayingResponse): MovieNowPlayingEntity {
        return MovieNowPlayingEntity(type.id, type.voteCount, type.video, type.voteAverage, type.title,
                type.popularity, type.posterPath, type.originalLang, type.originalTitle, type.genreIds,
                type.backdropPath, type.adult, type.overview, type.releaseDate)
    }

    /**
     * Map a list of [MovieNowPlayingResponse] to a collection of [MovieNowPlayingEntity]
     * @return [Collection]
     */
    override fun mapResponseListFromRemote(type: Collection<MovieNowPlayingResponse>): Collection<MovieNowPlayingEntity> {
        return type.map { mapResponseFromRemote(it) }
    }
}