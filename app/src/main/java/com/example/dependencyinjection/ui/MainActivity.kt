package com.example.dependencyinjection.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.dependencyinjection.TAG
import com.example.dependencyinjection.databinding.ActivityMainBinding
import com.example.dependencyinjection.model.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel.fetchUserDataFromApi()
        userViewModel.data.observe(this,{
            Log.d(TAG, "List of Users are $it")
        })
    }
}