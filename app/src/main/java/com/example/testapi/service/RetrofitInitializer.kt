package com.example.testapi.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {
  private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

  private val retrofitInstance: Retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  fun getInstance(): ApiService = retrofitInstance.create(ApiService::class.java)
}