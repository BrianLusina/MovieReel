package com.moviereel.data.executor

import com.moviereel.domain.executor.ThreadExecutor
import java.util.concurrent.*
import javax.inject.Inject

/**
 * @author lusinabrian on 11/05/18.
 * @Notes Decorated [ThreadPoolExecutor]
 */
open class JobExecutor @Inject constructor() : ThreadExecutor{
    companion object {
        private const val INITIAL_POOL_SIZE = 3
        private const val MAX_POOL_SIZE = 5

        // sets the amount of time an idle thread waits before terminating
        private const val KEEP_ALIVE_TIME = 10

        //sets the time unit to seconds
        private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
    }

    private val workQueue : LinkedBlockingQueue<Runnable> = LinkedBlockingQueue()
    private val threadFactory : ThreadFactory = JobThreadFactory()
    private val threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME.toLong(), KEEP_ALIVE_TIME_UNIT, workQueue, threadFactory)

    override fun execute(runnable: Runnable?) {
        if (runnable === null){
            throw IllegalArgumentException("Runnable to execute cannot be null")
        }
        threadPoolExecutor.execute(runnable)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0
        companion object {
            private const val THREAD_NAME = "android_"
        }

        override fun newThread(runnable: Runnable?): Thread {
            return Thread(runnable, THREAD_NAME + counter++)
        }
    }

}