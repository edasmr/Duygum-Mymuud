package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class PersonelMuudPoco(


    @SerializedName("anxiety") val anxiety: Int,
    @SerializedName("confused") val confused: Int,
    @SerializedName("happiness") val happiness: Int,
    @SerializedName("sorrow") val sorrow: Int,
    @SerializedName("anger") val anger: Int,
    @SerializedName("physical") val physical: Int,
    @SerializedName("targetUserId") val targetUserId: Int,
    @SerializedName("identify") val identify: String? = null,
)
