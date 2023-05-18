package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class SearchPublicProfilesPoco(

    @SerializedName("text") val text: String? =null,
    @SerializedName("page") val page: Int
)
