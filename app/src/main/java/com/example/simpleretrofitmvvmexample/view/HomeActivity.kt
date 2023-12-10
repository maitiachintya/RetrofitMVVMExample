package com.example.simpleretrofitmvvmexample.view

import android.R.attr.setupActivity
import android.app.ProgressDialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleretrofitmvvmexample.adapter.ShowActivityAdapter
import com.example.simpleretrofitmvvmexample.databinding.ActivityHomeBinding
import com.example.simpleretrofitmvvmexample.viewmodel.HomeViewModel
import com.example.simpleretrofitmvvmexample.viewmodel.HomeViewModelFactory


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var showActivityAdapter: ShowActivityAdapter
  //  private var progressDialog : ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, HomeViewModelFactory(this)).get(HomeViewModel::class.java)
        binding.rcvwItems.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcvwItems.isNestedScrollingEnabled = true
        binding.rcvwItems.setHasFixedSize(true)
      //  progressDialog = ProgressDialog(this)
        viewModel.postLists.observe(this, { posts ->
          //  progressDialog!!.dismiss()
            if(posts != null) {
                showActivityAdapter = ShowActivityAdapter(posts)
                binding.rcvwItems.adapter = showActivityAdapter
            }
        })
        viewModel.fetchPosts()
       // progressDialog!!.show()

    }
}