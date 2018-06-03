package com.moviereel.data.mapper.movies

import com.moviereel.data.factory.MovieDataFactory
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class MovieNowPlayingDataMapperTest {

    private lateinit var movieNowPlayingDataMapper: MovieNowPlayingDataMapper

    @Before
    @Throws(Exception::class)
    fun setUp() {
        movieNowPlayingDataMapper = MovieNowPlayingDataMapper()
    }

    @Test
    fun mapFromEntityMapsData(){
        val movieNowPlayingEntity = MovieDataFactory.makeMovieNowPlayingEntity()
        val movieModel = movieNowPlayingDataMapper.mapFromEntity(movieNowPlayingEntity)
        assertMovieNowPlayingDataEquality(movieNowPlayingEntity, movieModel)
    }

    @Test
    fun mapToEntityMapsData(){
        val movieNowPlayingModel = MovieDataFactory.makeMovieNowPlayingModel()
        val movieNowPlayingEntity = movieNowPlayingDataMapper.mapToEntity(movieNowPlayingModel)
        assertMovieNowPlayingDataEquality(movieNowPlayingEntity, movieNowPlayingModel)
    }

    private fun assertMovieNowPlayingDataEquality(movieNowPlayingEntity: MovieNowPlayingDataEntity,
                                                  movieNowPlayingCacheModel: MovieNowPlayingModel) {
        assertEquals(movieNowPlayingEntity.id, movieNowPlayingModel.id)
        assertEquals(movieNowPlayingEntity.voteCount, movieNowPlayingModel.voteCount)
        assertEquals(movieNowPlayingEntity.video, movieNowPlayingModel.video)
        assertEquals(movieNowPlayingEntity.voteAverage, movieNowPlayingModel.voteAverage)
        assertEquals(movieNowPlayingEntity.title, movieNowPlayingModel.title)
        assertEquals(movieNowPlayingEntity.popularity, movieNowPlayingModel.popularity)
        assertEquals(movieNowPlayingEntity.posterPath, movieNowPlayingModel.posterPath)
        assertEquals(movieNowPlayingEntity.originalLang, movieNowPlayingModel.originalLang)
        assertEquals(movieNowPlayingEntity.originalTitle, movieNowPlayingModel.originalTitle)
        assertEquals(movieNowPlayingEntity.genreIds, movieNowPlayingModel.genreIds)
        assertEquals(movieNowPlayingEntity.backdropPath, movieNowPlayingModel.backdropPath)
        assertEquals(movieNowPlayingEntity.adult, movieNowPlayingModel.adult)
        assertEquals(movieNowPlayingEntity.overview, movieNowPlayingModel.overview)
        assertEquals(movieNowPlayingEntity.releaseDate, movieNowPlayingModel.releaseDate)
    }
}