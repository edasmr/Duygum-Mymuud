package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class FollowRequest(
    @SerializedName("creationTime") val creationTime: String? = null,
    @SerializedName("id") val id: Int,
    @SerializedName("skip") val skip: Int,
    @SerializedName("type") val type: Int,
    @SerializedName("targetUserId") val targetUserId: Int,
    @SerializedName("sourceUserId") val sourceUserId: Int,
    @SerializedName("updateTime") val updateTime: String? = null,
    @SerializedName("tag") val tag: String? = null,
    @SerializedName("machineUTC") val machineUTC: String? = null,
    @SerializedName("hashtag") val hashtag: String? = null,
    @SerializedName("requestStatus") val requestStatus: FollowRequestStatus,
    @SerializedName("acceptDate") val acceptDate: String? = null,
    @SerializedName("sentDate") val sentDate: String? = null,
    @SerializedName("notificationId") val notificationId: Int



    )
