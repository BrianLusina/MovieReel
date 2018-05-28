package com.moviereel.data.mapper.movies

import com.moviereel.data.mapper.Mapper
import com.moviereel.data.models.movies.MovieNowPlayingEntity
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import javax.inject.Inject

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Map a [MovieNowPlayingEntity] to and from a [MovieNowPlayingModel] instance when data is moving between
 * this layer and the Domain layer
 */
open class MovieNowPlayingMapper @Inject constructor() : Mapper<MovieNowPlayingEntity, MovieNowPlayingModel> {

    /**
     * Map a [MovieNowPlayingEntity] instance to a [MovieNowPlayingModel] instance
     */
    override fun mapFromEntity(type: MovieNowPlayingEntity): MovieNowPlayingModel {
        return MovieNowPlayingModel(type.id, type.voteCount, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLang, type.originalTitle,
                type.genreIds, type.backdropPath, type.adult, type.overview, type.releaseDate)
    }

    override fun mapFromListEntity(type: List<MovieNowPlayingEntity>): Collection<MovieNowPlayingModel> {
        val movieList = arrayListOf<MovieNowPlayingModel>()
        for (entity in type){
            val model = mapFromEntity(entity)
            movieList.add(model)
        }
        return movieList
    }

    /**
     * Map a [MovieNowPlayingModel] instance to a [MovieNowPlayingEntity] instance
     */
    override fun mapToEntity(type: MovieNowPlayingModel): MovieNowPlayingEntity {
        return MovieNowPlayingEntity(type.id, type.voteCount, type.video, type.voteAverage,
                type.title, type.popularity, type.posterPath, type.originalLang, type.originalTitle,
                type.genreIds, type.backdropPath, type.adult, type.overview, type.releaseDate)
    }

    override fun mapToListEntity(type: Collection<MovieNowPlayingModel>): Collection<MovieNowPlayingEntity> {
        val movieList = arrayListOf<MovieNowPlayingEntity>()
        for (entity in type){
            val model = mapToEntity(entity)
            movieList.add(model)
        }
        return movieList
    }
}