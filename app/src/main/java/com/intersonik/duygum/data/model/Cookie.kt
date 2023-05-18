package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class Cookie(

    @SerializedName("accessToken") val accessToken: String? = null,
    @SerializedName("take") val take: Int?=0,
    @SerializedName("skip") val skip: Int?=0,
    @SerializedName("userId") val userId: Int?=0,
    @SerializedName("userName") val userName: String? = "",
    @SerializedName("receivedOrSent") val receivedOrSent: String? = "",
    @SerializedName("personalMuudFilter") val personalMuudFilter: String? = "",
    @SerializedName("categoryOfPie") val categoryOfPie: String? = "",
    @SerializedName("targetUserId") val targetUserId: Int?=0,
    @SerializedName("hashtag") val hashtag: String? = "",
    @SerializedName("peersInteractedSearch") val peersInteractedSearch: String? = ""


)
