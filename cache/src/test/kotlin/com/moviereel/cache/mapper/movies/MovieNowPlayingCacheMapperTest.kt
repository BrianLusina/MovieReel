package com.moviereel.cache.mapper.movies

import com.moviereel.cache.db.models.movie.MovieNowPlayingCacheModel
import com.moviereel.cache.factory.MovieCacheDataFactory
import com.moviereel.cache.movies.nowplaying.NowPlayingCacheMapper
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieNowPlayingCacheMapperTest {

    private lateinit var movieNowPlayingCacheMapper: NowPlayingCacheMapper

    @Before
    fun setUp() {
        movieNowPlayingCacheMapper = NowPlayingCacheMapper()
    }

    @Test
    fun mapFromCachedMapsData() {
        val dataEntity = MovieCacheDataFactory.makeMovieNowPlayingDataEntity()
        val cachedModel = movieNowPlayingCacheMapper.mapToCached(dataEntity)
        assertDataEquality(dataEntity, cachedModel)
    }

    @Test
    fun mapToCachedMapsData() {
        val cachedModel = MovieCacheDataFactory.makeMovieNowPlayingCacheModel()
        val dataEntity = movieNowPlayingCacheMapper.mapFromCached(cachedModel)
        assertDataEquality(dataEntity, cachedModel)
    }

    private fun assertDataEquality(dataEntity: MovieNowPlayingDataEntity,
                                                  cachedEntity : MovieNowPlayingCacheModel){
        assertEquals(dataEntity.adult, cachedEntity.isAdult)
        assertEquals(dataEntity.backdropPath, cachedEntity.backdropPath)
        assertEquals(dataEntity.genreIds, cachedEntity.genreIds)
        assertEquals(dataEntity.id, cachedEntity.id)
        assertEquals(dataEntity.originalLang, cachedEntity.originalLanguage)
        assertEquals(dataEntity.originalTitle, cachedEntity.originalTitle)
        assertEquals(dataEntity.overview, cachedEntity.overview)
        assertEquals(dataEntity.posterPath, cachedEntity.posterPath)
        assertEquals(dataEntity.popularity, cachedEntity.popularity)
        assertEquals(dataEntity.releaseDate, cachedEntity.releaseDate)
        assertEquals(dataEntity.title, cachedEntity.title)
        assertEquals(dataEntity.video, cachedEntity.video)
        assertEquals(dataEntity.voteCount, cachedEntity.voteCount)
        assertEquals(dataEntity.voteAverage, cachedEntity.voteAverage)
    }
}