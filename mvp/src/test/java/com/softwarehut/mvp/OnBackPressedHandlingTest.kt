package com.softwarehut.mvp

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.softwarehut.mvp.domain.decorators.BaseActivityDecorator
import com.softwarehut.mvp.domain.paramless.BaseActivity
import com.softwarehut.mvp.domain.paramless.OnBackPressedHandling
import org.junit.Before
import org.junit.Test

class OnBackPressedHandlingTest {

    private lateinit var cut: OnBackPressedHandling

    private lateinit var activity: BaseActivity<*>

    @Before
    fun beforeTest() {
        activity = mock()
    }

    @Test
    fun handle_withDecoratorHandlingBackPressedAndTrueParameter_returnsTrue() {
        val decorator: BaseActivityDecorator = mock {
            on { shouldHandleBackPressed() } doReturn (true)
        }
        cut = OnBackPressedHandling(decorator, activity)
        assert(cut.handle(true))
    }

    @Test
    fun handle_withDecoratorNotHandlingBackPressedAndTrueParameter_returnsFalse() {
        val decorator: BaseActivityDecorator = mock {
            on { shouldHandleBackPressed() } doReturn (false)
        }
        cut = OnBackPressedHandling(decorator, activity)
        assert(!cut.handle(true))
    }

    @Test
    fun handle_withDecoratorNotHandlingBackPressedAndFalseParameter_returnsFalse() {
        val decorator: BaseActivityDecorator = mock {
            on { shouldHandleBackPressed() } doReturn (false)
        }
        cut = OnBackPressedHandling(decorator, activity)
        assert(!cut.handle(false))
    }
}