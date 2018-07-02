package com.softwarehut.mvp.domain.decorators

import android.os.Bundle
import android.support.v7.widget.Toolbar

open class BaseActivityDecorator(val activity: ActivityAccess)
    : ActivityAccess {

    override fun shouldHandleBackPressed(): Boolean = false

    override fun onBackPressed() {
    }

    override fun onNotHandleBackPressed() {
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
        activity.setSupportActionBar(toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
    }
}