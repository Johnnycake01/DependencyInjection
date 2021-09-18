package com.example.dependencyinjection.model.repository

import com.example.dependencyinjection.model.data.UserData
import retrofit2.Response

interface UserRepository {
    suspend fun getUser():Response<List<UserData>>
}