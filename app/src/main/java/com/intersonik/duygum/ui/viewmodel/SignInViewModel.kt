package com.intersonik.duygum.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intersonik.duygum.data.model.Login
import com.intersonik.duygum.data.preferences.MyPreferences
import com.intersonik.duygum.data.remote.LoginResponse
import com.intersonik.duygum.data.repository.MymuudRepository
import com.intersonik.duygum.util.Resource
import com.intersonik.duygum.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val repository: MymuudRepository,private val preferences: MyPreferences) :
    ViewModel() {

    private val _login = MutableLiveData<Resource<LoginResponse>>()
    val login: LiveData<Resource<LoginResponse>> get() = _login


    fun postLogin(login: Login) {
        viewModelScope.launch {
            repository.postLogin(login).let {
                when (it.status) {
                    Status.SUCCESS -> _login.postValue(Resource.success(it.data!!))
                    Status.LOADING -> _login.postValue(Resource.loading())
                    Status.ERROR -> _login.postValue(Resource.error(it.message.toString()))
                }
            }
        }
    }

    fun setToken(token:String)=preferences.setToken(token)
    fun getToken():String{
       return preferences.getToken().toString()
    }
}
