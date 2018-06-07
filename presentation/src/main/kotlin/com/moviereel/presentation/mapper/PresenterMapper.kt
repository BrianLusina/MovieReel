package com.moviereel.presentation.mapper

/**
 * @author lusinabrian on 04/06/18.
 * @Notes Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer layers
 *
 * @param <V> the view model input type
 * @param <P> the domain model output type
*/
interface PresenterMapper<out V, in P> {

    fun mapToView(type: P): V

}