package com.moviereel.presentation.mapper.movies

import com.moviereel.domain.models.movies.MovieNowPlayingDomainModel
import com.moviereel.presentation.mapper.PresenterMapper
import com.moviereel.presentation.model.movies.NowPlayingPresenterModel

/**
 * @author lusinabrian on 04/06/18.
 * @Notes Maps data to [NowPlayingPresenterModel] when data is moving from Domain layer to View layer
 */
open class NowPlayingPresenterMapper : PresenterMapper<NowPlayingPresenterModel, MovieNowPlayingDomainModel> {

    override fun mapToView(type: MovieNowPlayingDomainModel): NowPlayingPresenterModel {
        return NowPlayingPresenterModel(
                type.voteCount, type.id, type.video, type.voteAverage, type.title, type.popularity,
                type.posterPath, type.originalLang, type.originalTitle, type.genreIds, type.backdropPath,
                type.adult, type.overview, type.releaseDate
        )
    }
}