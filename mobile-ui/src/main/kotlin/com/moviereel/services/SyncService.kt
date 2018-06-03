package com.moviereel.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian on 19/4/17
 * * Sync Service used to sync api data with the database for offline use
 * *
 */
class SyncService : Service() {

    @Inject
    lateinit var mCompositeDisposable: CompositeDisposable

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }
}
