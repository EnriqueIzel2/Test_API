package com.example.testapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapi.model.Post
import com.example.testapi.repository.PostRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel(private val repository: PostRepository) : ViewModel() {

  val postList = MutableLiveData<List<Post>>()
  val errorMessage = MutableLiveData<String>()

  fun getPosts() {
    val request = repository.getPosts()
    request.enqueue(object : Callback<List<Post>> {
      override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
        postList.postValue(response.body())
      }

      override fun onFailure(call: Call<List<Post>>, t: Throwable) {
        errorMessage.postValue(t.message)
      }
    })
  }
}