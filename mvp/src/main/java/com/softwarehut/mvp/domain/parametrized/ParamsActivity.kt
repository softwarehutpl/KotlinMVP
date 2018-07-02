package com.softwarehut.mvp.domain.parametrized

import android.content.Intent
import android.os.Bundle
import com.softwarehut.mvp.domain.paramless.BaseActivity
import com.softwarehut.mvp.domain.paramless.Presenter

abstract class ParamsActivity<TPresenter : Presenter> : BaseActivity<TPresenter>() {

    protected lateinit var params: Bundle
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val params: Bundle = if (savedInstanceState == null) {
            provideInitialModel()
        } else {
            savedInstanceState.getParcelable(paramsStorageKey)
        }
        this.params = params
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelable(paramsStorageKey, params)
        super.onSaveInstanceState(outState)
    }

    open fun provideInitialModel(): Bundle {
        val containsKey = intent.hasExtra(paramsStorageKey)
        return if (containsKey) {
            intent.getBundleExtra(paramsStorageKey)
        } else {
            throw ParamsNotFoundException()
        }
    }

    companion object {
        private val paramsStorageKey: String
            get() = "ParamsStorageKey"

        fun putParams(intent: Intent, params: Bundle) {
            intent.putExtra(paramsStorageKey, params)
        }
    }
}