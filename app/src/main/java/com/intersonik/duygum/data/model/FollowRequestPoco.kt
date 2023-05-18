package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class FollowRequestPoco(
    @SerializedName("targetUserId") val targetUserId: Int,
    @SerializedName("sourceUserId") val sourceUserId: Int,
    @SerializedName("isPending") val isPending: Boolean,
    @SerializedName("sentDate") val sentDate: String? = null,
    @SerializedName("accessToken") val accessToken: String? = null,
    @SerializedName("acceptDate") val acceptDate: String? = null


    )
