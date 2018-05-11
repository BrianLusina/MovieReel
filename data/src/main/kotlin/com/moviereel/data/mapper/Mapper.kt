package com.moviereel.data.mapper

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Interface for model mappers. It provides helper methods that facilitate retrieving of
 * models from outer data source layers
 * @param <T> the cached model input type
 * @param <T> the remote model input type
 * @param <V> the model return type
 */
interface Mapper<E, D> {
    fun mapFromEntity(type: E): D

    fun mapFromListEntity(type: List<E>) : Collection<D>

    fun mapToEntity(type: D): E

    fun mapToListEntity(type: Collection<D>) : Collection<E>
}