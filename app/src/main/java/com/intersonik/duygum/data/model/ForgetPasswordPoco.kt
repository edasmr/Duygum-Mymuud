package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class ForgetPasswordPoco(

    @SerializedName("guid1") val guid1: String? = null,
    @SerializedName("guid2") val guid2: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null,


    )



