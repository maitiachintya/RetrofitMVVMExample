package com.example.simpleretrofitmvvmexample.viewmodel

import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleretrofitmvvmexample.model.ShowAPIModelItem
import com.example.simpleretrofitmvvmexample.util.RetrofitInstance
import com.example.simpleretrofitmvvmexample.view.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(val homeActivity: HomeActivity) : ViewModel() {
    private var progressDialog : ProgressDialog? = null
    private var _postLists = MutableLiveData<List<ShowAPIModelItem>>()
    val postLists: MutableLiveData<List<ShowAPIModelItem>> get() = _postLists

   fun fetchPosts() {
       progressDialog = ProgressDialog(homeActivity)
       progressDialog?.show()
       RetrofitInstance.retrofit.getInstance().enqueue(object : Callback<List<ShowAPIModelItem>>{
           override fun onResponse(
               call: Call<List<ShowAPIModelItem>>,
               response: Response<List<ShowAPIModelItem>>
           ) {
              progressDialog?.dismiss()
               if(response.body()!=null){
                    _postLists.value = response.body()
               }
               else{
                   postLists.value = null
               }
           }

           override fun onFailure(call: Call<List<ShowAPIModelItem>>, t: Throwable) {
               progressDialog?.dismiss()
               postLists.value = null
               Log.d("Failure",t.message.toString())
           }
       })
    }
}