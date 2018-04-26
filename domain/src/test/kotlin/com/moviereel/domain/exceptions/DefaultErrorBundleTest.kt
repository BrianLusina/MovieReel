package com.moviereel.domain.exceptions

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DefaultErrorBundleTest{

    lateinit var defaultErrorBundle : DefaultErrorBundle
    @Mock lateinit var mockException : Exception

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        defaultErrorBundle = DefaultErrorBundle(mockException)
    }

    @Test
    fun testGetErrorMessageInteraction() {
        defaultErrorBundle.getErrorMessage()

        verify(mockException).message
    }
}