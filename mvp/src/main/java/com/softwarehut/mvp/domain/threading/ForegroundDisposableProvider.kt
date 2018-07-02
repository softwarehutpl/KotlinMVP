package com.softwarehut.mvp.domain.threading

import io.reactivex.disposables.CompositeDisposable

interface ForegroundDisposableProvider {

    val foregroundDisposable: CompositeDisposable
}