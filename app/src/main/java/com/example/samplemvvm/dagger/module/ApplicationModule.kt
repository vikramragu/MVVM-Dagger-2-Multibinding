package com.example.mymvvm.dagger.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(app : Application) : Context {
        return app.applicationContext
    }

    @Provides
    fun provideString() : String{
        return "hello world"
    }

}