package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class Chat(

    @SerializedName("content") val blockedUserName: String? = null,
    @SerializedName("targetUserId") val targetUserId: Int,
    @SerializedName("sourceUserId") val sourceUserId: Int
)
