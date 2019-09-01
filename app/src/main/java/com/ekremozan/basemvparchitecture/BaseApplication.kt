package com.ekremozan.basemvparchitecture

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.ekremozan.note.di.component.ApplicationComponent
import com.ekremozan.note.di.component.DaggerApplicationComponent
import com.ekremozan.note.di.module.ApplicationModule

class BaseApplication : Application() {

    private lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()
    }

    private fun setup() {
        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        mApplicationComponent.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return mApplicationComponent
    }

    companion object {
        lateinit var instance: BaseApplication private set
    }
}
