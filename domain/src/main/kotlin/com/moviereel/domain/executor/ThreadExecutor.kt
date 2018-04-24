package com.moviereel.domain.executor

import java.util.concurrent.Executor

/**
 * @author lusinabrian on 18/04/18.
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the [UseCase]
 */
interface ThreadExecutor : Executor