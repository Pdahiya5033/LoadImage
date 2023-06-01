package com.example.loadimg.networking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object MakeUrl {
    val retrofit: ImgLoadApi? by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImgLoadApi::class.java)
    }
}