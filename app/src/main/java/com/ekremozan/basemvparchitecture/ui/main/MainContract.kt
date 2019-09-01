package com.ekremozan.basemvparchitecture.ui.main

import com.ekremozan.basemvparchitecture.ui.base.IPresenter
import com.ekremozan.basemvparchitecture.ui.base.IView
import com.ekremozan.note.di.PerActivity

class MainContract {

    @PerActivity
    interface Presenter<V : View> : IPresenter<V>

    interface View : IView
}