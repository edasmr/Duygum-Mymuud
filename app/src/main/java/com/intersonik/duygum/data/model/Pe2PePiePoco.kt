package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class Pe2PePiePoco(

    @SerializedName("sourceUserName") val sourceUserName: String? = null,
    @SerializedName("targetUserName") val targetUserName: String? = null,
    @SerializedName("period") val period: String? = null

    )
