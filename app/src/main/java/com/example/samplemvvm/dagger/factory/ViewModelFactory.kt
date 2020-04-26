package com.example.samplemvvm.dagger.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory
    @Inject constructor(val viewModelMap : Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
    :ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val provider = viewModelMap[modelClass]
            ?: viewModelMap.entries.first { modelClass.isAssignableFrom(it.key) }.value
        return provider.get() as T
    }

}