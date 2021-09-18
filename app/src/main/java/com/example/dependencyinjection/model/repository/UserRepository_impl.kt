package com.example.dependencyinjection.model.repository

import com.example.dependencyinjection.model.data.UserData
import com.example.dependencyinjection.model.repository.UserRepository
import com.example.dependencyinjection.network.UserNetwork
import retrofit2.Response

class UserRepository_impl(private val retro: UserNetwork): UserRepository {
    override suspend fun getUser():Response<List<UserData>>{
        return retro.getUsers()
    }
}