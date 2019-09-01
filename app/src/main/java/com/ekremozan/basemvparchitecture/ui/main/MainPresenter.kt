package com.ekremozan.basemvparchitecture.ui.main

import android.content.Context
import com.ekremozan.basemvparchitecture.ui.base.BasePresenter
import com.ekremozan.note.di.ActivityContext
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainContract.View> @Inject
constructor(
    compositeDisposable: CompositeDisposable
) : BasePresenter<V>(compositeDisposable), MainContract.Presenter<V> {

    @Inject
    @field:ActivityContext
    lateinit var context: Context

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

    }

}