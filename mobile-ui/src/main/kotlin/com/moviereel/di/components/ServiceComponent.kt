package com.moviereel.di.components

import com.moviereel.di.scopes.PerService
import com.moviereel.di.modules.ServiceModule

import dagger.Component

/**
 * @author lusinabrian on 27/03/17
 */

@PerService
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ServiceModule::class))
interface ServiceComponent// TODO: 27/03/17 inject services here
// void inject();
