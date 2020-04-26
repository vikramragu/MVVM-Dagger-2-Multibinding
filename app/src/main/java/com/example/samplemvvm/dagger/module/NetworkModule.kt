package com.example.mymvvm.dagger.modules

import android.app.Application
import com.example.mymvvm.network.ClientApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    fun provideGson():GsonConverterFactory{
        return GsonConverterFactory.create(GsonBuilder().create())
    }

    @Provides
    fun provideOkHTTPClient(httpLoggingInterceptor: HttpLoggingInterceptor, cache: Cache) : OkHttpClient{

        return OkHttpClient.Builder()
            .readTimeout(30,TimeUnit.SECONDS)
            .connectTimeout(30,TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .cache(cache)
            .build()
    }

    @Provides
    fun provideInterceptor() : HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideClient(@Named("baseUrl")baseUrl : String, okHttpClient: OkHttpClient
                      ,gsonConverterFactory: GsonConverterFactory): ClientApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
        .create(ClientApi::class.java)


    @Provides
    fun provideHttpCache(application: Application) : Cache{
        val cacheSize = 5 * 1024 *1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }
}