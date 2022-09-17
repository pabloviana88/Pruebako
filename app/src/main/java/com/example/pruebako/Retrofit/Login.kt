package com.example.pruebako.Retrofit

import com.google.gson.annotations.SerializedName

data class Login(
 @SerializedName(Const.EMAIL_PARAM) var email: String,
 @SerializedName(Const.PASSWORD_PARAM) var password:String,
 )