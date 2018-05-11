package com.moviereel.data.repositories

import com.moviereel.data.mapper.movies.MovieNowPlayingMapper
import com.moviereel.data.models.movies.MovieNowPlayingEntity
import com.moviereel.data.source.movies.MovieDataStoreFactory
import com.moviereel.data.source.movies.stores.MovieRemoteDataStore
import com.moviereel.domain.models.movies.*
import com.moviereel.domain.repositories.MoviesRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Provides an implementation of the [MoviesRepository] interface for communicating to and from
 * data sources
 */
class MovieDataRepositoryImpl
@Inject
constructor(
        val factory: MovieDataStoreFactory,
        val movieNowPlayingMapper: MovieNowPlayingMapper)
    : MoviesRepository {

    private fun saveMoviesNowPlayingEntities(moviesNowPlaying: List<MovieNowPlayingEntity>): Completable {
        return factory.retrieveCacheDataStore().saveMoviesNowPlaying(moviesNowPlaying)
    }

    private fun saveMovieNowPlayingEntity(movieNowPlaying : MovieNowPlayingEntity) : Completable {
        return factory.retrieveCacheDataStore().saveMovieNowPlaying(movieNowPlaying)
    }

    override fun clearAllMovies(): Completable {
        val cacheDataStore = factory.retrieveCacheDataStore()
        return cacheDataStore.clearAllMovies()
    }

    override fun saveMoviesNowPlaying(moviesNowPlaying: List<MovieNowPlayingModel>): Completable {
        val movieNowPlayingEntities = moviesNowPlaying.map {
            movieNowPlayingMapper.mapToEntity(it)
        }
        return saveMoviesNowPlayingEntities(movieNowPlayingEntities)
    }

    override fun clearMoviesNowPlaying(): Completable {
        val cacheDataStore = factory.retrieveCacheDataStore()
        return cacheDataStore.clearMoviesNowPlaying()
    }

    override fun getMoviesNowPlayingList(page: Int, language: String): Flowable<List<MovieNowPlayingModel>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getMoviesNowPlaying(page, language)
                .toFlowable()
                .flatMap {
                    if (dataStore is MovieRemoteDataStore) {
                        saveMoviesNowPlayingEntities(it).toFlowable()
                    } else {
                        Flowable.just(it)
                    }
                }.map { list ->
                    list.map { listItem ->
                        movieNowPlayingMapper.mapFromEntity(listItem)
                    }
                }
    }

    override fun getMovieNowPlaying(id: Long): Flowable<MovieNowPlayingModel> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getMovieNowPlaying(id)
                .toFlowable()
                .flatMap {
                    if (dataStore is MovieRemoteDataStore) {
                        saveMovieNowPlayingEntity(it).toFlowable()
                    } else {
                        Flowable.just(it)
                    }
                }
                .map {
                    movieNowPlayingMapper.mapFromEntity(it)
                }
    }

    // TODO: implement below

    override fun getMoviesLatest(language: String): Flowable<MovieLatestModel> {
        val dataStore = factory.retrieveDataStore()
        return Flowable.just(MovieLatestModel(
                "", 0, arrayListOf(), "","", arrayListOf(), arrayListOf(),
                0, 0, arrayListOf(), "", ""
        ))
    }

    override fun getMoviesPopular(page: Int, language: String): Flowable<List<MoviePopularModel>> {
        return Flowable.just(listOf())
    }

    override fun getMoviesTopRated(page: Int, language: String, region: String): Flowable<List<MovieTopRatedModel>> {
        return Flowable.just(listOf())
    }

    override fun getMoviesUpcoming(page: Int, language: String, region: String): Flowable<List<MovieUpcomingModel>> {
        return Flowable.just(listOf())
    }
}