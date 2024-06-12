package com.example.newtry

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetroFitClient {

    var BaseUrl = "https://fakestoreapi.com/"


    val instance : ApiEndPoint by lazy {
        var RetroFit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build()).build()

        RetroFit.create(ApiEndPoint::class.java)
    }

}