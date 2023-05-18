package com.intersonik.duygum.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.intersonik.duygum.data.preferences.MyPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by
 * edasumer on 2.02.2023.
 */

@HiltViewModel
class HomeViewModel @Inject constructor(private val preferences: MyPreferences) : ViewModel() {

    fun getToken(): String {
        return preferences.getToken().toString()
    }
}