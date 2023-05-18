package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class PagingPoco(

    @SerializedName("skip") val skip: Int,
    @SerializedName("take") val take: Int,

    )
