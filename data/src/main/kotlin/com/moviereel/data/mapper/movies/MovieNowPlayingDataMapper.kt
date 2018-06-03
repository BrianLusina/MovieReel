package com.moviereel.data.mapper.movies

import com.moviereel.data.mapper.Mapper
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.domain.models.movies.MovieNowPlayingDomainModel
import javax.inject.Inject

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Map a [MovieNowPlayingDataEntity] to and from a [MovieNowPlayingModel] instance when data is moving between
 * this layer and the Domain layer
 */
open class MovieNowPlayingDataMapper @Inject constructor() : Mapper<MovieNowPlayingDataEntity, MovieNowPlayingDomainModel> {

    /**
     * Map a [MovieNowPlayingDataEntity] instance to a [MovieNowPlayingModel] instance
     */
    override fun mapFromEntity(type: MovieNowPlayingDataEntity): MovieNowPlayingDomainModel {
        return MovieNowPlayingDomainModel(type.id, type.voteCount, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLang, type.originalTitle,
                type.genreIds, type.backdropPath, type.adult, type.overview, type.releaseDate)
    }

    override fun mapFromListEntity(type: List<MovieNowPlayingDataEntity>): Collection<MovieNowPlayingDomainModel> {
        val movieList = arrayListOf<MovieNowPlayingDomainModel>()
        for (entity in type){
            val model = mapFromEntity(entity)
            movieList.add(model)
        }
        return movieList
    }

    /**
     * Map a [MovieNowPlayingModel] instance to a [MovieNowPlayingDataEntity] instance
     */
    override fun mapToEntity(type: MovieNowPlayingDomainModel): MovieNowPlayingDataEntity {
        return MovieNowPlayingDataEntity(type.id, type.voteCount, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLang, type.originalTitle,
                type.genreIds, type.backdropPath, type.adult, type.overview, type.releaseDate)
    }

    override fun mapToListEntity(type: Collection<MovieNowPlayingDomainModel>): Collection<MovieNowPlayingDataEntity> {
        val movieList = arrayListOf<MovieNowPlayingDataEntity>()
        for (entity in type){
            val model = mapToEntity(entity)
            movieList.add(model)
        }
        return movieList
    }
}