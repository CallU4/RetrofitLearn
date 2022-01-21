package com.example.retrofitlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitlearn.adapters.PostAdapter
import com.example.retrofitlearn.databinding.ActivityMainBinding
import com.example.retrofitlearn.models.Posts
import com.example.retrofitlearn.models.PostsItem
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val BASE_URL = "https://jsonplaceholder.typicode.com"

    private lateinit var bind: ActivityMainBinding

    lateinit var adapter: PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.rvPosts.layoutManager = LinearLayoutManager(this)

        getPostData()
    }

    private fun getPostData() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PostsApi::class.java)

        val retrofitData = retrofit.getData()

        retrofitData.enqueue(object : Callback<List<PostsItem>?> {
            override fun onResponse(
                call: Call<List<PostsItem>?>,
                response: Response<List<PostsItem>?>
            ) {
                val responseBody = response.body()!!

                adapter = PostAdapter(responseBody)
                adapter.notifyDataSetChanged()
                bind.rvPosts.adapter = adapter

            }

            override fun onFailure(call: Call<List<PostsItem>?>, t: Throwable) {
                Log.d("MyTag", "onFailure " + t.message)
            }
        })

    }


}