package com.example.retrofitlearn.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitlearn.databinding.TodoLayoutBinding
import com.example.retrofitlearn.models.Posts
import com.example.retrofitlearn.models.PostsItem

class PostAdapter(var postList: List<PostsItem>) : RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        var bind = TodoLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,
        false)

        return PostHolder(bind)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind.tvTitle.text = postList[position].body
    }

    override fun getItemCount(): Int = postList.size

    inner class PostHolder(val bind: TodoLayoutBinding) : RecyclerView.ViewHolder(bind.root)

}