package com.example.testapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapi.adapter.PostAdapter
import com.example.testapi.databinding.ActivityMainBinding
import com.example.testapi.repository.PostRepository
import com.example.testapi.service.RetrofitInitializer
import com.example.testapi.viewmodel.PostViewModel
import com.example.testapi.viewmodel.PostViewModelFactory

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private lateinit var postViewModel: PostViewModel
  private val apiService = RetrofitInitializer.getInstance()
  private val adapter by lazy { PostAdapter(applicationContext) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    postViewModel = ViewModelProvider(this, PostViewModelFactory(PostRepository(apiService))).get(
      PostViewModel::class.java
    )

    binding.recyclerView.adapter = adapter
  }

  override fun onStart() {
    super.onStart()

    postViewModel.postList.observe(this, Observer {
      adapter.setPostList(it)
    })

    postViewModel.errorMessage.observe(this, Observer {
      Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    })
  }

  override fun onResume() {
    super.onResume()

    postViewModel.getPosts()
  }
}