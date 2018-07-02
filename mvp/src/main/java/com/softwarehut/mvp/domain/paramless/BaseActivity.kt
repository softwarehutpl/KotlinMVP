package com.softwarehut.mvp.domain.paramless

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.softwarehut.mvp.domain.decorators.ActivityAccess
import com.softwarehut.mvp.domain.decorators.BaseActivityDecorator

abstract class BaseActivity<TPresenter : Presenter> : AppCompatActivity(), ActivityAccess, View {

    lateinit var presenter: TPresenter

    abstract fun createPresenter(): TPresenter

    open fun createDecorator(): BaseActivityDecorator {
        return BaseActivityDecorator(this)
    }

    private lateinit var decorator: BaseActivityDecorator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        presenter = createPresenter()
        decorator = createDecorator()
        decorator.onCreate(savedInstanceState)
        presenter.initialized()
    }

    override fun onStart() {
        super.onStart()
        presenter.onForeground()
    }

    override fun onStop() {
        super.onStop()
        presenter.onBackground()
    }

    override fun onDestroy() {
        presenter.cleanup()
        super.onDestroy()
    }

    override fun onBackPressed() {
        val handling = OnBackPressedHandling(decorator, this)
        if (!handling.handle(shouldHandleBackPressed())) {
            super.onBackPressed()
        }
    }

    override fun shouldHandleBackPressed(): Boolean {
        return false
    }

    override fun onNotHandleBackPressed() {
    }

    @LayoutRes
    abstract fun getContentView(): Int

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }
}