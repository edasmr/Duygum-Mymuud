package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class MuudImage(

    @SerializedName("id") val id: Int,
    @SerializedName("creationTime") val creationTime: String? = null,
    @SerializedName("updateTime") val updateTime: String? = null,
    @SerializedName("tag") val tag: String? = null,
    @SerializedName("machineUTC") val machineUTC: String? = null,
    @SerializedName("base64") val base64: String? = null,
    @SerializedName("extension") val extension: String? = null,
    @SerializedName("path") val path: String? = null,

    )
