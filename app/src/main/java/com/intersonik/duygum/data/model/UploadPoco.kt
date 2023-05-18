package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class UploadPoco(

    @SerializedName("accessToken") val accessToken: String? = null,
    @SerializedName("data") val data: String? = null,

    )
