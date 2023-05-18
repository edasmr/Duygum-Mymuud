package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class VerifySignupEmail(

    @SerializedName("email") val email: String? = null,
    @SerializedName("code") val code: String? = null,
)
