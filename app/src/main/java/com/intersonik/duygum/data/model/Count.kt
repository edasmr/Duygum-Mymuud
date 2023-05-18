package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class Count(

    @SerializedName("accessToken") val accessToken: String? = null,
    @SerializedName("take") val take: Int,
    @SerializedName("skip") val skip: Int,
    @SerializedName("type") val type: Int,
    @SerializedName("userName") val userName: String? = null,
    @SerializedName("hashtag") val hashtag: String? = null
)
