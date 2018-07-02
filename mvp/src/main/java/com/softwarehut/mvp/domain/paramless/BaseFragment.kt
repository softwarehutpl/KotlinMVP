package com.softwarehut.mvp.domain.paramless

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<TPresenter : Presenter> : Fragment(), com.softwarehut.mvp.domain.paramless.View {

    protected lateinit var presenter: TPresenter

    abstract fun createPresenter(): TPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getViewResource(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = createPresenter()
        presenter.initialized()
    }

    override fun onDestroyView() {
        presenter.cleanup()
        super.onDestroyView()
    }

    override fun onStart() {
        super.onStart()
        presenter.onForeground()
    }

    override fun onStop() {
        super.onStop()
        presenter.onBackground()
    }

    @LayoutRes
    abstract fun getViewResource(): Int
}