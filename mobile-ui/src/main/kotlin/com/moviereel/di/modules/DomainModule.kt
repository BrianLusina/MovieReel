package com.moviereel.di.modules

import com.moviereel.data.DataManager
import com.moviereel.di.scopes.PerApplication
import com.moviereel.domain.DomainManager
import dagger.Module
import dagger.Provides

/**
 * @author lusinabrian on 09/06/18.
 * @Notes provides dependencies from domain layer
 */
@Module
class DomainModule {

    @Provides
    @PerApplication
    fun providesDomainManager(dataManager : DataManager) : DomainManager{
        return dataManager
    }
}