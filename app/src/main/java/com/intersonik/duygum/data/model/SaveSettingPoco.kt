package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class SaveSettingPoco(

    @SerializedName("accessToken") val accessToken: String? =null,
    @SerializedName("pass") val pass: String? =null,
    @SerializedName("pass2") val pass2: String? =null,
    @SerializedName("isPublic") val isPublic: Boolean,
    @SerializedName("isReciprocity") val isReciprocity: Boolean,
    @SerializedName("isGraphicsShow") val isGraphicsShow: Boolean




    )



