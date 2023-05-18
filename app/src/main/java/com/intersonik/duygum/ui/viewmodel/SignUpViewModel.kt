package com.intersonik.duygum.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intersonik.duygum.data.model.SignupPoco
import com.intersonik.duygum.data.model.VerifySignupEmail
import com.intersonik.duygum.data.remote.LoginResponse
import com.intersonik.duygum.data.repository.MymuudRepository
import com.intersonik.duygum.util.Resource
import com.intersonik.duygum.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: MymuudRepository) :
    ViewModel() {

    private val _signUp = MutableLiveData<Resource<LoginResponse>>()
    val signUp: LiveData<Resource<LoginResponse>> get() = _signUp

    private val _verifyEmailCode = MutableLiveData<Resource<LoginResponse>>()
    val verifyEmailCode: LiveData<Resource<LoginResponse>> get() = _verifyEmailCode

    fun postSignUp(signUp: SignupPoco) {
        viewModelScope.launch {
            repository.postSignUp(signUp).let {
                when (it.status) {
                    Status.SUCCESS -> _signUp.postValue(Resource.success(it.data!!))
                    Status.LOADING -> _signUp.postValue(Resource.loading())
                    Status.ERROR -> _signUp.postValue(Resource.error(it.message.toString()))
                }
            }
        }
    }

    fun verifyEmailCode(verifySignupEmail: VerifySignupEmail) {
        viewModelScope.launch {
            repository.verifyEmailCode(verifySignupEmail).let {
                when (it.status) {
                    Status.SUCCESS -> _verifyEmailCode.postValue(Resource.success(it.data!!))
                    Status.LOADING -> _verifyEmailCode.postValue(Resource.loading())
                    Status.ERROR -> _verifyEmailCode.postValue(Resource.error(it.message.toString()))
                }
            }
        }
    }

}
