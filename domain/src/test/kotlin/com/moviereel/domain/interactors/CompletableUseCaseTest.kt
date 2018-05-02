package com.moviereel.domain.interactors

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.nhaarman.mockito_kotlin.given
import io.reactivex.schedulers.TestScheduler
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CompletableUseCaseTest {

    private lateinit var completableUseCase: CompletableUseCaseTestClass
    private lateinit var testCompletable: TestCompletable
    @Mock
    lateinit var  mockThreadExecutor: ThreadExecutor
    @Mock
    lateinit var mockPostExecutionThread: PostExecutionThread

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        completableUseCase = CompletableUseCaseTestClass(mockThreadExecutor, mockPostExecutionThread)
        testCompletable = TestCompletable()
        given(mockPostExecutionThread.scheduler).willReturn(TestScheduler())
    }

    @Test
    fun testBuildUseCaseCompletableWillReturnResult(){
        completableUseCase.execute(Params.EMPTY)
        completableUseCase.unsubscribe()
        assertThat(testCompletable.valuesCount).isZero()
    }
}