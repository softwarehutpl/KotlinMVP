package com.softwarehut.mvp.domain.stateless

import io.reactivex.disposables.CompositeDisposable

interface ForegroundDisposableProvider {

    val foregroundDisposable: CompositeDisposable
}