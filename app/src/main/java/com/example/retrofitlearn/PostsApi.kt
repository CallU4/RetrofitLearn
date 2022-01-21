package com.example.retrofitlearn

import com.example.retrofitlearn.models.PostsItem
import retrofit2.Call
import retrofit2.http.GET

interface PostsApi {

    @GET("/posts")
    fun getData(): Call<List<PostsItem>>
}