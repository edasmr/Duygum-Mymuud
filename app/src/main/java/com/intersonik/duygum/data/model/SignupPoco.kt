package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class SignupPoco(

    @SerializedName("email") val email: String? =null,
    @SerializedName("password") val password: String? =null,
    @SerializedName("passwordRepeat") val passwordRepeat: String? =null,
    @SerializedName("name") val name: String? =null,
    @SerializedName("surname") val surname: String? =null,
    @SerializedName("username") val username: String? =null

)
