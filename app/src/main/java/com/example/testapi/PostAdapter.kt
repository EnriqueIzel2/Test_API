package com.example.testapi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.testapi.databinding.ItemPostBinding

class PostAdapter(private val context: Context, private val postList: List<Post>) :
  Adapter<PostAdapter.ViewHolder>() {

  class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Post) {
      binding.postTitle.text = item.title
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      ItemPostBinding.inflate(
        LayoutInflater.from(context), parent, false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val post = postList[position]

    holder.bind(post)
  }

  override fun getItemCount(): Int = postList.size
}