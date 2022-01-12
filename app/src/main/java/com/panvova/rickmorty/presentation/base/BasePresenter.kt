package com.panvova.rickmorty.presentation.base

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Named

abstract class BasePresenter<V : BaseView> {

    @Inject
    @Named("Main")
    protected lateinit var coroutineDispatcherMain: CoroutineDispatcher

    @Inject
    @Named("IO")
    protected lateinit var coroutineDispatcherIO: CoroutineDispatcher

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