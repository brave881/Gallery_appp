package com.example.gallery1.network

import com.example.gallery1.model.AllPhotos
import com.example.gallery1.model.ResultPhoto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.unsplash.com/search/collections?query=office&page=1&per_page=15&client_id=zfDB6i-fsjUVEuyUJYGe4sVaWKr29czUV1paO7Wsohw
interface Api {

    @GET("/search/photos")
    fun getPhotos(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") per_page: Int?,
        @Query("client_id") client_id: String,
    ): Call<AllPhotos>

    @GET("/search/photos")
    fun getPhotosLatest(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") per_page: Int?,
        @Query("order_by") orederBy: String,
        @Query("client_id") client_id: String,
    ): Call<AllPhotos>


    @GET("photos/")
    fun searchAll(
        @Query("page") page: Int?,
        @Query("per_page") per_page: Int?,
        @Query("client_id") query: String,
    ): Call<List<ResultPhoto>>

}