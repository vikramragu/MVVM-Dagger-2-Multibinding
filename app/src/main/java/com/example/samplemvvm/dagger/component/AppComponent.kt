package com.example.samplemvvm.dagger.component

import android.app.Application
import com.example.mymvvm.dagger.modules.ApplicationModule
import com.example.mymvvm.dagger.modules.NetworkModule
import com.example.samplemvvm.SampleMVVMApplication
import com.example.samplemvvm.dagger.module.ActivityBuilderModule
import com.example.samplemvvm.dagger.module.ViewModelFactoryModule
import dagger.Binds

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton


@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class,
        ApplicationModule::class, NetworkModule::class, ViewModelFactoryModule::class])

interface AppComponent : AndroidInjector<SampleMVVMApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application) : Builder

        @BindsInstance
        fun baseUrl(@Named("baseUrl") baseUrl : String) : Builder

        fun build() : AppComponent
    }
}




