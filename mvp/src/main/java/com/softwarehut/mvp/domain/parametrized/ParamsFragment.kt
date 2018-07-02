package com.softwarehut.mvp.domain.parametrized

import android.os.Bundle
import android.view.View
import com.softwarehut.mvp.domain.paramless.BaseFragment
import com.softwarehut.mvp.domain.paramless.Presenter

abstract class ParamsFragment<TPresenter : Presenter> : BaseFragment<TPresenter>() {

    protected lateinit var params: Bundle
        private set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val params: Bundle = if (savedInstanceState == null) {
            createInitialParams()
        } else {
            savedInstanceState.getParcelable(paramsStorageKey)
        }
        this.params = params
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(paramsStorageKey, params)
        super.onSaveInstanceState(outState)
    }

    open fun createInitialParams(): Bundle {
        val containsKey = arguments?.containsKey(paramsStorageKey)
        return if (containsKey == true) {
            arguments!!.getBundle(paramsStorageKey)
        } else {
            throw ParamsNotFoundException()
        }
    }

    protected companion object {
        private val paramsStorageKey: String
            get() = "ParamsStorageKey"

        fun <TPresenter : Presenter> putParams(fragment: ParamsFragment<TPresenter>, params: Bundle)
                : ParamsFragment<TPresenter> {

            val bundle = Bundle()
            bundle.putBundle(paramsStorageKey, params)
            fragment.arguments = bundle
            return fragment

        }
    }
}