package com.example.simpleretrofitmvvmexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.simpleretrofitmvvmexample.R
import com.example.simpleretrofitmvvmexample.databinding.ActivityMainBinding
import com.example.simpleretrofitmvvmexample.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(LoginViewModel :: class.java)
        binding.buttonSubmit.setOnClickListener(View.OnClickListener {
            val username = binding.editTextUsername.text.toString()
            val userage = binding.editTextPassword.text.toString()
            viewModel.setUserData(username, userage)
            // Navigate to HomeActivity
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        })
    }
}