package com.ekremozan.basemvparchitecture.ui.base

import androidx.annotation.StringRes

interface IView {

    fun showLoading(message: String)

    fun hideLoading()

    fun showSnackbar(@StringRes resId: Int)

    fun showSnackbar(message: String?)

    fun showMessage(message: String?)

    fun showMessage(@StringRes resId: Int)

    fun hideKeyboard()

}