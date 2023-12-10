package com.example.simpleretrofitmvvmexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleretrofitmvvmexample.model.User
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _usermodel = MutableLiveData<User>()
    val usermodel : LiveData<User> get() = _usermodel

    fun setUserData(username : String, password : String){
        viewModelScope.launch {
            _usermodel.value = User(username, password)
        }
    }
}