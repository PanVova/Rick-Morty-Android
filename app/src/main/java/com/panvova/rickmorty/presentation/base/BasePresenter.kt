package com.panvova.rickmorty.presentation.base

import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.inject

abstract class BasePresenter<V : BaseView> {

    protected val coroutineDispatcherMain: CoroutineDispatcher by inject(CoroutineDispatcher::class.java, named("main"))
    protected val coroutineDispatcherIO: CoroutineDispatcher by inject(CoroutineDispatcher::class.java, named("io"))

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