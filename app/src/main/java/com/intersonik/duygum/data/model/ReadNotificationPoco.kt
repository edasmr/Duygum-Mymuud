package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class ReadNotificationPoco(
    @SerializedName("ids") val ids: Int,
    @SerializedName("accessToken") val accessToken: String? =null

)
