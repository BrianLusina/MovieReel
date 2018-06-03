package com.moviereel.cache.mapper

/**
 * @author lusinabrian on 02/06/18.
 * @Notes
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <C> the cached model input type
 * @param <E> the model return type
 */
interface CacheEntityMapper<C, E> {
    /**
     * Maps a Cached entity to a Data Entity
     */
    fun mapFromCached(type: C) : E

    /**
     * Maps a Data Entity to a Cached entity
     */
    fun mapToCached(type: E) : C
}