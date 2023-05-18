package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class MuudPoco(


    @SerializedName("anxiety") val anxiety: Int,
    @SerializedName("confused") val confused: Int,
    @SerializedName("happiness") val happiness: Int,
    @SerializedName("sorrow") val sorrow: Int,
    @SerializedName("anger") val anger: Int,
    @SerializedName("physical") val physical: Int,
    @SerializedName("targetId") val targetId: Int,
    @SerializedName("subAnxiety") val subAnxiety: String? = null,
    @SerializedName("subConfused") val subConfused: String? = null,
    @SerializedName("subHappiness") val subHappiness: String? = null,
    @SerializedName("subSorrow") val subSorrow: String? = null,
    @SerializedName("subAnger") val subAnger: String? = null,
    @SerializedName("subPhysical") val subPhysical: String? = null,
    @SerializedName("muudText") val muudText: String? = null,
    @SerializedName("muudLink") val muudLink: MuudLink,
    @SerializedName("muudImage") val muudImage: MuudImage,
    @SerializedName("comments") val comments: MuudComment? = null,
    @SerializedName("accessToken") val accessToken: String? = null,
    @SerializedName("hashtags") val hashtags: Hashtag? = null,








    )
