package com.example.testapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapi.repository.PostRepository

class PostViewModelFactory(private val repository: PostRepository): ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
      PostViewModel(this.repository) as T
    } else {
      throw IllegalArgumentException("ViewModel Not Found")
    }
  }
}