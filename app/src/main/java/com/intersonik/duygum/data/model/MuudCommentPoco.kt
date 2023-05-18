package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class MuudCommentPoco(

    @SerializedName("content") val content: String? = null,
    @SerializedName("muudId") val muudId: Int,
    @SerializedName("taggedUsers") val taggedUsers:Int? = null

    )
