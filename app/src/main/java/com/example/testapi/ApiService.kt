package com.example.testapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

  @GET("posts")
  fun getPosts(): Call<List<Post>>

  @GET("posts/1")
  fun getPost(): Call<Post>
}