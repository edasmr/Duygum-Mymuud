package com.intersonik.duygum.data.preferences

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by
 * edasumer on 19.12.2022.
 */

class MyPreferences @Inject constructor(private val preferences: SharedPreferences){

    fun setToken(token:String)= preferences.edit().putString(TOKEN,token).apply()
    fun getToken()=preferences.getString(TOKEN,"")

    companion object {
        const val TOKEN="token"
    }
}