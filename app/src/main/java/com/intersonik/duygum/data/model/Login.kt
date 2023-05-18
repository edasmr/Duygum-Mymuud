package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class Login(

    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null

    )
