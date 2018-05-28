package com.moviereel.remote.mapper

/**
 * @author lusinabrian on 28/05/18.
 * @Notes Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 * @param <R> the remote response model input type
 * @param <E> the entity model output type
*/
interface EntityMapper<in R, out E> {

    /**
     * Maps from a Response model of type R to entity Model E
     * @param type
     * @return [E]
     */
    fun mapResponseFromRemote(type: R): E

    /**
     * Maps from a collection of Response objects R to a collection of Entity objects E
     * @param type
     * @return [Collection]
     */
    fun mapResponseListFromRemote(type: Collection<R>) : Collection<E>
}