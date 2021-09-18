package com.example.dependencyinjection.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.model.data.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.dependencyinjection.model.repository.UserRepository


@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository):ViewModel() {
        private var _data:MutableLiveData<List<UserData>> = MutableLiveData()
        val data:LiveData<List<UserData>> = _data

    fun fetchUserDataFromApi(){
        viewModelScope.launch(Dispatchers.IO){
            val response = repository.getUser()
            if (response.isSuccessful){
                val responseBody = response.body()
                _data.postValue(responseBody)
            }

        }
    }


}

//@HiltViewModel
//class DonutViewModel @Inject constructor(handle: SavedStateHandle?, repository: RecipeRepository?) :
//    ViewModel()