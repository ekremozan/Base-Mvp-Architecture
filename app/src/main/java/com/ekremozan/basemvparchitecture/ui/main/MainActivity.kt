package com.ekremozan.basemvparchitecture.ui.main

import android.os.Bundle
import com.ekremozan.basemvparchitecture.R
import com.ekremozan.basemvparchitecture.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity: BaseActivity(), MainContract.View {

    @Inject
    lateinit var mPresenter: MainContract.Presenter<MainContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent!!.inject(this)
        mPresenter.onAttach(this@MainActivity)
    }
}