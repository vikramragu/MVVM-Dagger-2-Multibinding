package com.example.samplemvvm.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.samplemvvm.dagger.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module
class ViewModelFactoryModule {

    /*@Binds
    abstract fun bindViewModelFactory(viewmodelfactory : ViewModelFactory) : ViewModelProvider.Factory*/

    @Provides
    fun viewModelFactory(providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>):
            ViewModelProvider.Factory {
        return ViewModelFactory(providerMap)
    }
}
