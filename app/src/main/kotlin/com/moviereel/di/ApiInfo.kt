package com.moviereel.di

import kotlin.annotation.Retention
import kotlin.annotation.AnnotationRetention.RUNTIME

import javax.inject.Qualifier

/**
 * @author lusinabrian on 27/03/17
 */

@Qualifier
@Retention(RUNTIME)
annotation class ApiInfo
