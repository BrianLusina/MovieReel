package com.moviereel.cache.mapper.movies

import com.moviereel.cache.db.entities.movie.MovieNowPlayingCacheEntity
import com.moviereel.cache.mapper.CacheEntityMapper
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity

/**
 * @author lusinabrian on 02/06/18.
 * @Notes Maps a Cached [MovieNowPlayingCacheEntity] instance to a [MovieNowPlayingDataEntity] instance
 */
class MovieNowPlayingCacheMapper : CacheEntityMapper<MovieNowPlayingCacheEntity, MovieNowPlayingDataEntity>{

    override fun mapFromCached(type: MovieNowPlayingCacheEntity): MovieNowPlayingDataEntity {
        return MovieNowPlayingDataEntity(type.id, type.voteCount, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLanguage,
                type.originalTitle, type.genreIds, type.backdropPath, type.isAdult, type.overview,
                type.releaseDate)
    }

    override fun mapToCached(type: MovieNowPlayingDataEntity): MovieNowPlayingCacheEntity {
        return MovieNowPlayingCacheEntity(
                type.voteCount, type.id, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLang,
                type.originalTitle, type.genreIds, type.backdropPath, type.adult, type.overview,
                type.releaseDate
        )
    }
}