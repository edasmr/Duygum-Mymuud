package com.intersonik.duygum.data.remote

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("httpCode") val httpCode: Int,
    @SerializedName("single") val single: String?,
    @SerializedName("list") val list: String?,
    @SerializedName("total") val total: Int,
    @SerializedName("message") val message: String,
    @SerializedName("language") val language: String
)