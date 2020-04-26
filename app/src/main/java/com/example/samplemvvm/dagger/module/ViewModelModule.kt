package com.example.samplemvvm.dagger.module

import androidx.lifecycle.ViewModel
import com.example.samplemvvm.dagger.annotation.ViewModelKey
import com.example.samplemvvm.view.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainViewModel(mainActivityViewModel: MainActivityViewModel) : ViewModel
}