package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class ProfileVisitPoco(

    @SerializedName("isMyProfile") val isMyProfile: Boolean,
    @SerializedName("isProfilePublic") val isProfilePublic: Boolean,
    @SerializedName("isFollowing") val isFollowing: Boolean,
    @SerializedName("userPoco") val userPoco: UserDto,
    @SerializedName("userNick") val userNick: String? = null,

    )
