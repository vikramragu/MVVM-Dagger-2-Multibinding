package com.example.mymvvm.dagger.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ApplicationModule {

    @Provides
    fun provideApplication(app : Application) : Application{
        return app
    }

    @Provides
    fun provideString() : String{
        return "hello world"
    }

}