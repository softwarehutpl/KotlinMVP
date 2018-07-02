package com.softwarehut.mvp.domain.stateless

import io.reactivex.disposables.CompositeDisposable

interface BackgroundDisposableProvider {

    val backgroundDisposable: CompositeDisposable
}