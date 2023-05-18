package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class Hashtag(

    @SerializedName("id") val id:Int,
    @SerializedName("creationTime") val creationTime: String? = null,
    @SerializedName("updateTime") val updateTime: String? = null,
    @SerializedName("tag") val tag: String? = null,
    @SerializedName("machineUTC") val machineUTC: String? = null,
    @SerializedName("content") val content: String? = null,

    )
