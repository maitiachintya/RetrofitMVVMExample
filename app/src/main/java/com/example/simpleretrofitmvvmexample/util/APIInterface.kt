package com.example.simpleretrofitmvvmexample.util

import com.example.simpleretrofitmvvmexample.model.ShowAPIModelItem
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("/posts")
    open fun getInstance() : Call<List<ShowAPIModelItem>>
}