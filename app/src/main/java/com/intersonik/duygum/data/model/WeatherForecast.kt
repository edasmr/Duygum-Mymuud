package com.intersonik.duygum.data.model

import com.google.gson.annotations.SerializedName

data class WeatherForecast(


    @SerializedName("summary") val summary: String? = null,
    @SerializedName("date") val date: String,
    @SerializedName("temperatureC") val temperatureC: Int,
    @SerializedName("temperatureF") val temperatureF: Int,


    )
