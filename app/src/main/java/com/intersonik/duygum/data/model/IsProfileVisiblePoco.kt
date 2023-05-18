package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class IsProfileVisiblePoco(

    @SerializedName("visitUserName") val visitUserName: String? = null,
    @SerializedName("sourceUserName") val sourceUserName: String? = null,
    @SerializedName("visitUserId") val visitUserId:Int

    )
