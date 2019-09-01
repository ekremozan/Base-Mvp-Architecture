package com.ekremozan.note.di.component

import android.app.Application
import android.content.Context
import com.ekremozan.basemvparchitecture.BaseApplication
import com.ekremozan.note.di.ApplicationContext
import com.ekremozan.note.di.module.ApplicationModule
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: BaseApplication)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun compositeDisposable(): CompositeDisposable
}