package com.ekremozan.basemvparchitecture.ui.base

import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BasePresenter<V : IView> @Inject
constructor(
    val compositeDisposable: CompositeDisposable
) : IPresenter<V> {

    var mvpView: V? = null
        private set

    val isViewAttached: Boolean
        get() = mvpView != null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        compositeDisposable.clear()
        mvpView = null
    }

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException :
        RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")

    companion object {

        private val TAG = "BasePresenter"
    }
}
