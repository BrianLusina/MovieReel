package com.moviereel.data.mapper.movies

import com.moviereel.data.mapper.Mapper
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import javax.inject.Inject

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Map a [MovieNowPlayingDataEntity] to and from a [MovieNowPlayingModel] instance when data is moving between
 * this layer and the Domain layer
 */
open class MovieNowPlayingMapper @Inject constructor() : Mapper<MovieNowPlayingDataEntity, MovieNowPlayingModel> {

    /**
     * Map a [MovieNowPlayingDataEntity] instance to a [MovieNowPlayingModel] instance
     */
    override fun mapFromEntity(type: MovieNowPlayingDataEntity): MovieNowPlayingModel {
        return MovieNowPlayingModel(type.id, type.voteCount, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLang, type.originalTitle,
                type.genreIds, type.backdropPath, type.adult, type.overview, type.releaseDate)
    }

    override fun mapFromListEntity(type: List<MovieNowPlayingDataEntity>): Collection<MovieNowPlayingModel> {
        val movieList = arrayListOf<MovieNowPlayingModel>()
        for (entity in type){
            val model = mapFromEntity(entity)
            movieList.add(model)
        }
        return movieList
    }

    /**
     * Map a [MovieNowPlayingModel] instance to a [MovieNowPlayingDataEntity] instance
     */
    override fun mapToEntity(type: MovieNowPlayingModel): MovieNowPlayingDataEntity {
        return MovieNowPlayingDataEntity(type.id, type.voteCount, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLang, type.originalTitle,
                type.genreIds, type.backdropPath, type.adult, type.overview, type.releaseDate)
    }

    override fun mapToListEntity(type: Collection<MovieNowPlayingModel>): Collection<MovieNowPlayingDataEntity> {
        val movieList = arrayListOf<MovieNowPlayingDataEntity>()
        for (entity in type){
            val model = mapToEntity(entity)
            movieList.add(model)
        }
        return movieList
    }
}