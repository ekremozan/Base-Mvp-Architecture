package com.ekremozan.basemvparchitecture.ui.base

interface IPresenter<V : IView> {

    fun onAttach(view: V)

    fun onDetach()
}
