package com.moviereel.domain.interactors

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.nhaarman.mockito_kotlin.given
import io.reactivex.schedulers.TestScheduler
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SingleUseCaseTest {

    private lateinit var singleUseCase: SingleUseCaseTestClass
    private lateinit var testObserver: TestDisposableSingleObserver<Any>
    @Mock
    lateinit var  mockThreadExecutor: ThreadExecutor
    @Mock
    lateinit var mockPostExecutionThread: PostExecutionThread

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        singleUseCase = SingleUseCaseTestClass(mockThreadExecutor, mockPostExecutionThread)
        testObserver = TestDisposableSingleObserver()
        given(mockPostExecutionThread.scheduler).willReturn(TestScheduler())
    }

    @Test
    fun testBuildUseCaseSingleObservableReturnCorrectResult(){
        singleUseCase.execute(testObserver, Params.EMPTY)
        singleUseCase.dispose()

        Assertions.assertThat(testObserver.valuesCount).isZero()
    }

    @Test
    fun testSubscriptionWhenExecutingUseCase(){
        singleUseCase.execute(testObserver, Params.EMPTY)
        singleUseCase.dispose()

        Assertions.assertThat(testObserver.isDisposed).isTrue()
    }

}