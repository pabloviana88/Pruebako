package com.example.pruebako.Controller






import com.example.pruebako.Model.Login
import com.example.pruebako.Model.LoginResponse
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.Response

interface Apiservice {

    @Multipart
    @POST("/")
     fun createEmployee(
        @Part("email") email: String,
        @Part("password") password: String
    ): Response<Login>

//Const.API_PATH +Const.LOGIN_PATH
    @Headers("Authorization:ejercicio1", "Platform:Android")
    @POST("/")
     fun loguear(@Body data: Login):Call<LoginResponse>

     @FormUrlEncoded
     @POST("/")
     fun pushPot(
         @Field("email") email: String,
         @Field("password") password: String
     ):Response<ResponseBody>

    @Headers("Authorization:ejercicio1", "Platform:Android")
    @POST("/")
    fun pushPoth(@Body data: Login):Call<LoginResponse>


    @POST("/")
    suspend fun createEmployee(@Body requestBody: RequestBody): Response<ResponseBody>

    @FormUrlEncoded
    @POST("/")
    suspend fun createEmployees(@FieldMap params: HashMap<String?, String?>): Response<LoginResponse>

    @Multipart
    @POST("/")
    suspend fun uploadEmployeeData(@PartMap map: HashMap<String?, RequestBody?>): Response<LoginResponse>

}


