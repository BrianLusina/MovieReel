package com.moviereel.domain.factory

/**
 * @author lusinabrian on 27/04/18.
 * @Notes Factory class for data instances
 */
class DataFactory {

    companion object Factory {
        fun randomUuid(): String {
            return java.util.UUID.randomUUID().toString()
        }
    }
}