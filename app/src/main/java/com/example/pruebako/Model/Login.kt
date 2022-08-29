package com.example.pruebako.Model

import com.example.pruebako.Model.Const
import com.google.gson.annotations.SerializedName

data class Login(
 @SerializedName(Const.EMAIL_PARAM) var email: String,
 @SerializedName(Const.PASSWORD_PARAM) var password:String,
 )