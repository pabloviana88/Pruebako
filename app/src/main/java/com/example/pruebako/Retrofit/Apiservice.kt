package com.example.pruebako.Retrofit

import okhttp3.RequestBody
import retrofit2.http.*
import retrofit2.Response

interface Apiservice {

    companion object{
        const val BASE_URL ="http://testandroid.macropay.com.mx"
    }

    @Multipart
    @POST("/")
    suspend fun uploadEmployeeData(@PartMap map: HashMap<String?, RequestBody?>): Response<LoginResponse>

}


