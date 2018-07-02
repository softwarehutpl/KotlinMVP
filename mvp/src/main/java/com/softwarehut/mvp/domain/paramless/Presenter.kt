package com.softwarehut.mvp.domain.paramless

import com.softwarehut.mvp.common.Cleanable
import com.softwarehut.mvp.domain.threading.BackgroundDisposableProvider
import com.softwarehut.mvp.domain.threading.ForegroundDisposableProvider

interface Presenter : Cleanable,
        BackgroundDisposableProvider,
        ForegroundDisposableProvider {

    val view: View

    fun initialized()

    fun onForeground()

    fun onBackground()
}