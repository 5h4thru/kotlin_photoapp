package com.example.shathru.photoapp.api

import com.example.shathru.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET


interface PhotoAPI {
    @GET("?key=5690400-2337b251d946b064442b62cf7&q=nature&image_type=photo")
    fun getPhotos() : Call<PhotoList>
}