package com.ekremozan.note.di.component

import com.ekremozan.basemvparchitecture.ui.main.MainActivity
import com.ekremozan.note.di.PerActivity
import com.ekremozan.note.di.module.ActivityModule
import dagger.Component


@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}