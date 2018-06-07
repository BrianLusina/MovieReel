package com.moviereel.domain.io

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class SchedulerProviderImpl : SchedulerProvider {

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun start() {
        Schedulers.start()
    }

    override fun shutdown() {
        Schedulers.shutdown()
    }

    override fun single(): Scheduler {
        return Schedulers.single()
    }
}
