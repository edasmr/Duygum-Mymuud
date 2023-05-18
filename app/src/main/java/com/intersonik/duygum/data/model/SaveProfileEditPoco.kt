package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class SaveProfileEditPoco(

    @SerializedName("accessToken") val accessToken: String? =null,
    @SerializedName("email") val email: String? =null,
    @SerializedName("bio") val bio: String? =null,
    @SerializedName("location") val location: String? =null,
    @SerializedName("username") val username: String? =null,
    @SerializedName("birthdate") val birthdate: String? =null,
    @SerializedName("name") val name: String? =null,
    @SerializedName("surname") val surname: String? =null,
    @SerializedName("isPublic") val isPublic: Boolean
)
