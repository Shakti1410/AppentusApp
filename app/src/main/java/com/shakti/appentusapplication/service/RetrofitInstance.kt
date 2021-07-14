package com.shakti.appentusapplication.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        val baseUrl="https://picsum.photos/v2/"
        fun getRetrofitInstance(): Retrofit {

            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();
        }
    }
}