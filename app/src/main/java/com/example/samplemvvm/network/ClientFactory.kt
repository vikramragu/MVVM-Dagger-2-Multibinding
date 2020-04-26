package com.example.mymvvm.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ClientFactory {

    fun client(): ClientApi = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breeds/list/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpBuilder().build())
        .build()
        .create(ClientApi::class.java)

    private fun loggingIterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    private fun okHttpBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(loggingIterceptor())
}