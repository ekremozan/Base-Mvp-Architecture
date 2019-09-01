package com.ekremozan.basemvparchitecture.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ekremozan.basemvparchitecture.BaseApplication
import com.ekremozan.basemvparchitecture.R
import com.ekremozan.basemvparchitecture.utils.CommonUtils
import com.ekremozan.note.di.component.ActivityComponent
import com.ekremozan.note.di.component.DaggerActivityComponent
import com.ekremozan.note.di.module.ActivityModule
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity(), IView, BaseFragment.Callback {

    private var mProgressDialog: ProgressDialog? = null

    var activityComponent: ActivityComponent? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as BaseApplication).getApplicationComponent())
            .build()
    }

    override fun showSnackbar(message: String?) {
        if (message != null) {
            showSnackBarMessage(message)
        } else {
            showSnackBarMessage(getString(R.string.some_error))
        }
    }

    private fun showSnackBarMessage(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        val textView = sbView
            .findViewById<View>(R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        snackbar.show()
    }
    override fun showSnackbar(@StringRes resId: Int) {
        showSnackbar(getString(resId))
    }

    override fun showLoading(message: String) {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this, message)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun showMessage(message: String?) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show()
        }
    }

    override fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun onFragmentDetached(tag: String) {

    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}