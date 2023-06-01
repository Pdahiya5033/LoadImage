package com.example.loadimg.networking
import com.example.loadimg.model.ImgData
import retrofit2.http.GET
interface ImgLoadApi {
    @GET("photos")
    suspend fun getPics(): List<ImgData>
}