package com.softwarehut.mvp

import com.nhaarman.mockito_kotlin.mock
import com.softwarehut.mvp.domain.decorators.ActivityAccess
import com.softwarehut.mvp.domain.decorators.BaseActivityDecorator
import org.junit.Before
import org.junit.Test

class BaseActivityDecoratorTest {

    private lateinit var cut: BaseActivityDecorator

    @Before
    fun beforeTest() {
        val activityAccess: ActivityAccess = mock()
        cut = BaseActivityDecorator(activityAccess)
    }

    @Test
    fun shouldHandleBackPressed_ShouldReturnFalse() {
        assert(!cut.shouldHandleBackPressed())
    }
}