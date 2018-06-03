package com.moviereel.cache.movies.nowplaying

import com.moviereel.cache.db.models.movie.MovieNowPlayingCacheModel
import com.moviereel.cache.mapper.CacheEntityMapper
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity

/**
 * @author lusinabrian on 02/06/18.
 * @Notes Maps a Cached [MovieNowPlayingCacheModel] instance to a [MovieNowPlayingDataEntity] instance
 */
class NowPlayingCacheMapper : CacheEntityMapper<MovieNowPlayingCacheModel, MovieNowPlayingDataEntity>{

    override fun mapFromCached(type: MovieNowPlayingCacheModel): MovieNowPlayingDataEntity {
        return MovieNowPlayingDataEntity(type.id, type.voteCount, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLanguage,
                type.originalTitle, type.genreIds, type.backdropPath, type.isAdult, type.overview,
                type.releaseDate)
    }

    override fun mapToCached(type: MovieNowPlayingDataEntity): MovieNowPlayingCacheModel {
        return MovieNowPlayingCacheModel(
                type.voteCount, type.id, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLang,
                type.originalTitle, type.genreIds, type.backdropPath, type.adult, type.overview,
                type.releaseDate
        )
    }
}