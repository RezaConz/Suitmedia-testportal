package com.example.suitmedia_v2.network

import com.example.suitmedia_v2.network.models.BaseClass
import com.example.suitmedia_v2.network.models.UserBaseClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("/api/users?page=1&per_page=10")
   fun getAllUsers(): Call<BaseClass>

    @GET("/api/users/{id}")
   fun getUser(@Path(value="id") id:String): Call<UserBaseClass>

    companion object{
        val BASE_URL="https://reqres.in"
    }
}