package com.example.samplemvvm

import com.example.samplemvvm.dagger.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class SampleMVVMApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).baseUrl("htpps://").build()
    }

}