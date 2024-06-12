package com.example.newtry

import com.example.newtry.models.ProductListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("products")
    fun GetProduct() : Call<ProductListResponse>
}
