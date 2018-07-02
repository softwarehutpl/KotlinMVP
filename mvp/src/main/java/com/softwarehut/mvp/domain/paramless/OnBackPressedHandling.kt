package com.softwarehut.mvp.domain.paramless

import com.softwarehut.mvp.domain.decorators.BaseActivityDecorator

class OnBackPressedHandling(private val decorator: BaseActivityDecorator,
                            private val activity: BaseActivity<*>) {

    fun handle(shouldHandle: Boolean): Boolean {
        val shouldHandleBackPressed = decorator.shouldHandleBackPressed() && shouldHandle
        return if (shouldHandleBackPressed) {
            activity.onBackPressed()
            decorator.onBackPressed()
            true
        } else {
            activity.onNotHandleBackPressed()
            decorator.onNotHandleBackPressed()
            false
        }
    }
}