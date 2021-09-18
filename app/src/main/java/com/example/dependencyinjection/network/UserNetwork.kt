package com.example.dependencyinjection.network

import com.example.dependencyinjection.model.data.UserData
import retrofit2.Response
import retrofit2.http.GET

interface UserNetwork {
    @GET("users")
    suspend fun getUsers(): Response<List<UserData>>
}