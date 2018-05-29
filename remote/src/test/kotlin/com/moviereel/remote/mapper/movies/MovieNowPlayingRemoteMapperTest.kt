package com.moviereel.remote.mapper.movies

import com.moviereel.remote.factory.MovieFactory
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class MovieNowPlayingRemoteMapperTest {

    private lateinit var movieNowPlayingRemoteMapper: MovieNowPlayingRemoteMapper

    @Before
    @Throws(Exception::class)
    fun setUp() {
        movieNowPlayingRemoteMapper = MovieNowPlayingRemoteMapper()
    }

    @Test
    fun mapResponseFromRemoteMapsData(){
        val movieApiResponse = MovieFactory.makeMovieNowPlayingResponse()
        val movieDataEntity = movieNowPlayingRemoteMapper.mapResponseFromRemote(movieApiResponse)

        assertEquals(movieApiResponse.adult, movieDataEntity.adult)
        assertEquals(movieApiResponse.title, movieDataEntity.title)
        assertEquals(movieApiResponse.backdropPath, movieDataEntity.backdropPath)
        assertEquals(movieApiResponse.genreIds, movieDataEntity.genreIds)
        assertEquals(movieApiResponse.id, movieDataEntity.id)
        assertEquals(movieApiResponse.originalLang, movieDataEntity.originalLang)
        assertEquals(movieApiResponse.originalTitle, movieDataEntity.originalTitle)
        assertEquals(movieApiResponse.overview, movieDataEntity.overview)
        assertEquals(movieApiResponse.posterPath, movieDataEntity.posterPath)
        assertEquals(movieApiResponse.popularity, movieDataEntity.popularity)
        assertEquals(movieApiResponse.voteCount, movieDataEntity.voteCount)
        assertEquals(movieApiResponse.voteAverage, movieDataEntity.voteAverage)
        assertEquals(movieApiResponse.releaseDate, movieDataEntity.releaseDate)
    }

    @Ignore
    @Test
    fun mapResponseListFromRemoteMapsData(){
        val movieApiResponses = MovieFactory.makeMovieNowPlayingResponseCollection()
        val movieDataEntities = movieNowPlayingRemoteMapper.mapResponseListFromRemote(movieApiResponses)
    }
}