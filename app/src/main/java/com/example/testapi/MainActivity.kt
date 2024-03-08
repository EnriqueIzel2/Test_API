package com.example.testapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val apiService = RetrofitInitializer.instance.create(ApiService::class.java)
    val call = apiService.getPosts()


    call.enqueue(object : Callback<List<Post>> {
      override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
        if (response.isSuccessful) {
          val result = response.body()
          binding.recyclerView.adapter = PostAdapter(applicationContext, result.orEmpty())

          Log.i("Resultado Posts", "onResponse: ${result}")
        } else {
          Log.e("Resultado Posts", "onResponse: erro ruim")
        }
      }

      override fun onFailure(call: Call<List<Post>>, t: Throwable) {
        Log.e("Resultado Posts", "onFailure: erro na requisição ${t.message}")
      }
    })
  }
}