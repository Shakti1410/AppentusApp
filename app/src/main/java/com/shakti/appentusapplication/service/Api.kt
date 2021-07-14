package com.shakti.appentusapplication.service


import com.shakti.appentusapplication.model.ResponseImage
import com.shakti.appentusapplication.model.ResponseImageItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("list")
    suspend fun getImages(@Query("page")page:Int):List<ResponseImageItem>
}