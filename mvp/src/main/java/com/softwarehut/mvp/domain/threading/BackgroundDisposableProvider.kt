package com.softwarehut.mvp.domain.threading

import io.reactivex.disposables.CompositeDisposable

interface BackgroundDisposableProvider {

    val backgroundDisposable: CompositeDisposable
}