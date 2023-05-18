package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class SearchPoco(

    @SerializedName("accessToken") val accessToken: String? =null,
    @SerializedName("searchQuery") val searchQuery: String? =null,
    @SerializedName("take") val take: Int,
    @SerializedName("skip") val skip: Int,



)
