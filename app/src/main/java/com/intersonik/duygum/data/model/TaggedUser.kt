package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class TaggedUser(


    @SerializedName("id") val id: Int,
    @SerializedName("taggedUserId") val taggedUserId: Int,
    @SerializedName("creationTime") val creationTime: String,
    @SerializedName("updateTime") val updateTime: String,
    @SerializedName("machineUTC") val machineUTC: String,
    @SerializedName("tag") val tag: String? = null,


    )
