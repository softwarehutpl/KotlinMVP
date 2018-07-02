package com.softwarehut.mvp.domain.decorators

import android.os.Bundle
import android.support.v7.widget.Toolbar

interface ActivityAccess {

    fun onCreate(savedInstanceState: Bundle?)

    fun setSupportActionBar(toolbar: Toolbar?)

    fun shouldHandleBackPressed(): Boolean

    fun onBackPressed()

    fun onNotHandleBackPressed()
}