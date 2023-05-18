package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class BlockUser(

    @SerializedName("blockedUserName") val blockedUserName: String? = null
)
