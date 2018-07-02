package com.softwarehut.mvp.domain.paramless

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter(override val view: View) : Presenter {

    override val foregroundDisposable: CompositeDisposable = CompositeDisposable()

    override val backgroundDisposable: CompositeDisposable = CompositeDisposable()

    override fun initialized() {
    }

    override fun onForeground() {
    }

    override fun onBackground() {
        foregroundDisposable.dispose()
    }

    override fun cleanup() {
        backgroundDisposable.dispose()
    }
}