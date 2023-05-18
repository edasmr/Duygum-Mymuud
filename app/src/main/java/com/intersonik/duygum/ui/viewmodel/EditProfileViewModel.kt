package com.intersonik.duygum.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intersonik.duygum.data.model.Cookie
import com.intersonik.duygum.data.model.Login
import com.intersonik.duygum.data.model.SaveProfileEditPoco
import com.intersonik.duygum.data.model.UserDto
import com.intersonik.duygum.data.preferences.MyPreferences
import com.intersonik.duygum.data.remote.LoginResponse
import com.intersonik.duygum.data.repository.MymuudRepository
import com.intersonik.duygum.util.Resource
import com.intersonik.duygum.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(private val repository: MymuudRepository,private val preferences: MyPreferences) :
    ViewModel() {

    private val _editProfile = MutableLiveData<Resource<LoginResponse>>()
    val editProfile: LiveData<Resource<LoginResponse>> get() = _editProfile

    private val _userInfo = MutableLiveData<Resource<UserDto>>()
    val userInfo: LiveData<Resource<UserDto>> get() = _userInfo


    fun postEditProfile(editProfile: SaveProfileEditPoco) {
        viewModelScope.launch {
            repository.saveUserProfileEdit(editProfile).let {
                when (it.status) {
                    Status.SUCCESS -> _editProfile.postValue(Resource.success(it.data!!))
                    Status.LOADING -> _editProfile.postValue(Resource.loading())
                    Status.ERROR -> _editProfile.postValue(Resource.error(it.message.toString()))
                }
            }
        }
    }

    fun getUserInfo(userInfo:Cookie){
        viewModelScope.launch {
            repository.getUserInfo(userInfo).let {
                when(it.status){
                    Status.SUCCESS -> _userInfo.postValue(Resource.success(it.data!!))
                    Status.LOADING -> _userInfo.postValue(Resource.loading())
                    Status.ERROR -> _userInfo.postValue(Resource.error(it.message.toString()))
                }
            }
        }
    }

    fun setToken(token:String)=preferences.setToken(token)
    fun getToken():String{
        return preferences.getToken().toString()
    }
}
