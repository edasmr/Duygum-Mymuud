package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class NotificationPoco(

    @SerializedName("id") val id: Int,
    @SerializedName("accessToken") val accessToken: String? = null,

    )
