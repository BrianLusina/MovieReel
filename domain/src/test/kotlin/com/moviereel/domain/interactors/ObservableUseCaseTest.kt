package com.moviereel.domain.interactors

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.nhaarman.mockito_kotlin.given
import io.reactivex.schedulers.TestScheduler
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ObservableUseCaseTest {

    private lateinit var observableUseCase: ObservableUseCaseTestClass
    private lateinit var testObserver: TestDisposableObserver<Any>
    @Mock lateinit var  mockThreadExecutor: ThreadExecutor
    @Mock lateinit var mockPostExecutionThread: PostExecutionThread

    @Rule
    @JvmField
    var expectedException = ExpectedException.none()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        observableUseCase = ObservableUseCaseTestClass(mockThreadExecutor, mockPostExecutionThread)
        testObserver = TestDisposableObserver()
        given(mockPostExecutionThread.scheduler).willReturn(TestScheduler())
    }

    @Test
    fun testBuildUseCaseObservableReturnCorrectResult(){
        observableUseCase.execute(testObserver, Params.EMPTY)
        observableUseCase.dispose()

        assertThat(testObserver.valuesCount).isZero()
    }

    @Test
    fun testSubscriptionWhenExecutingUseCase(){
        observableUseCase.execute(testObserver, Params.EMPTY)
        observableUseCase.dispose()

        assertThat(testObserver.isDisposed).isTrue()
    }

    @Ignore
    @Test
    fun testShouldFailWhenExecutingWithNullObserver(){
        expectedException.expect(NullPointerException::class.java)
        // fixme: pass in null instead of testObserver without modifying external implementation
        observableUseCase.execute(testObserver, Params.EMPTY)
    }
}