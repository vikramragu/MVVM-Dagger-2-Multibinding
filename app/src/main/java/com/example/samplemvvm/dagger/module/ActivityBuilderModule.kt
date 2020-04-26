package com.example.samplemvvm.dagger.module

import com.example.samplemvvm.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelFactoryModule::class])
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesInjectMainActivity(): MainActivity

}