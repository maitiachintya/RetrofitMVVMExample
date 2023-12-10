package com.example.simpleretrofitmvvmexample.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface :: class.java)
    }
    /*val apiService: APIInterface by lazy {
        retrofit.create(APIInterface::class.java)
    }*/
}