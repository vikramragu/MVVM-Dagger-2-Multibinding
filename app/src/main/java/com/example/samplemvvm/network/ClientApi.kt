package com.example.mymvvm.network

import com.example.mymvvm.network.responsebody.DogsResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ClientApi {

    @GET("all")
    suspend fun getDogsList() : Response<DogsResponseModel>

}