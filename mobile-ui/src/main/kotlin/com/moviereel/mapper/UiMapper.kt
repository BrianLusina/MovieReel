package com.moviereel.mapper

/**
 * @author lusinabrian on 07/06/18.
 * @Notes
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer layers
 * @param <D> the view input type
 * @param <V> the view model output type
 */
interface UiMapper<out V, in D> {

    fun mapToViewModel(type: D): V
}