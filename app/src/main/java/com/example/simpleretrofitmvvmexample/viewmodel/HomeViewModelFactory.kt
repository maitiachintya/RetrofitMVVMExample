package com.example.simpleretrofitmvvmexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simpleretrofitmvvmexample.view.HomeActivity

class HomeViewModelFactory(val homeActivity: HomeActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel :: class.java)){
            return HomeViewModel(homeActivity) as T
        }
        throw IllegalArgumentException("Data fetch failed")
    }
}