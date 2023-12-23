package com.example.suitmedia_v2.network.models

import com.google.gson.annotations.SerializedName

data class UserClass(
    @SerializedName("id") val id:String,
    @SerializedName(value="email") val email:String,
    @SerializedName(value = "first_name") val firstName:String,
    @SerializedName(value = "last_name") val lastName:String,
    @SerializedName(value = "avatar") val avatar:String
)
