package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class UserDto(

    @SerializedName("id") val id: Int,
    @SerializedName("permission") val permission: Int? = null,
    @SerializedName("bio") val bio: String? = null,
    @SerializedName("displayName") val displayName: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("surname") val surname: String? = null,
    @SerializedName("username") val username: String? = null,
    @SerializedName("profilePhoto") val profilePhoto: String? = null,
    @SerializedName("profilePhotoExtension") val profilePhotoExtension: String? = null,
    @SerializedName("location") val location: String? = null,
    @SerializedName("birthDate") val birthDate: String? = null,
    @SerializedName("isPublic") val isPublic: Boolean? = null,
    @SerializedName("isReciprocity") val isReciprocity: Boolean? = null,
    @SerializedName("followRequests") val followRequests: FollowRequest,
    @SerializedName("isGraphicsShow") val isGraphicsShow: Boolean,
    @SerializedName("nameSurnameUserName") val nameSurnameUserName: String? = null,



    )
