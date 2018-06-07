package com.moviereel.data

import com.moviereel.data.source.DataCache
import com.moviereel.domain.DomainManager
import javax.inject.Inject

/**
 * @author lusinabrian on 05/06/18.
 * @Notes Data manager that implements [DomainManager] to access data not related to making API
 * calls or DB access
 */
class DataManager
@Inject
constructor(val dataCache: DataCache): DomainManager{

    override fun getFirstStart(): Boolean {
        return dataCache.getFirstStart()
    }

    override fun setFirstStart(setFirstStart: Boolean) {
        dataCache.setFirstStart(setFirstStart)
    }

}