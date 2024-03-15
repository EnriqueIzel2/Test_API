package com.example.testapi.service

import com.example.testapi.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

  @GET("posts")
  fun getPosts(): Call<List<Post>>

  @GET("posts/1")
  fun getPost(): Call<Post>
}