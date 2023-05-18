package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class FollowerFollowingPoco(

    @SerializedName("accessToken") val accessToken: String? = null,
    @SerializedName("userId") val userId: String? = null,
    @SerializedName("skip") val skip: Int,
    @SerializedName("take") val take: Int,


    )
