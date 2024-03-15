package com.example.testapi.repository

import com.example.testapi.service.ApiService

class PostRepository(private val apiService: ApiService) {

  fun getPosts() = apiService.getPosts()
}