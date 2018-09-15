package com.moviereel.mapper.movies

import com.moviereel.mapper.UiMapper
import com.moviereel.models.movies.NowPlayingViewModel
import com.moviereel.presentation.model.movies.NowPlayingPresenterModel

/**
 * @author lusinabrian on 07/06/18.
 * @Notes Maps a [NowPlayingPresenterModel] to a [NowPlayingViewModel] when data is moving between
 * this layer and Presentation Layer
 */
class NowPlayingViewMapper: UiMapper<NowPlayingViewModel, NowPlayingPresenterModel> {

    override fun mapToViewModel(type: NowPlayingPresenterModel): NowPlayingViewModel {
        return NowPlayingViewModel(
                type.voteCount,
                type.id,
                type.video,
                type.voteAverage,
                type.title,
                type.popularity,
                type.posterPath,
                type.originalLanguage,
                type.originalTitle,
                type.genreIds,
                type.backdropPath,
                type.isAdult,
                type.overview,
                type.releaseDate
        )
    }
}