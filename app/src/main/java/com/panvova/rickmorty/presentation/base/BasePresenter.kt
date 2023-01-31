package com.panvova.rickmorty.presentation.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

abstract class BasePresenter<V : BaseView> {

    protected val coroutineDispatcherMain: CoroutineDispatcher = Dispatchers.Main
    protected val coroutineDispatcherIO: CoroutineDispatcher = Dispatchers.IO

    protected var view: V? = null

    open fun attachView(view: V) {
        this.view = view
        loadData()
    }

    open fun loadData() {}

    open fun detachView(view: V) {
        if (this.view == view) {
            this.view = null
        }
    }
}