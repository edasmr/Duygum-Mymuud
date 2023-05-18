package com.intersonik.duygum.data.repository

import com.intersonik.duygum.common.BaseRepository
import com.intersonik.duygum.data.model.*
import com.intersonik.duygum.data.remote.LoginResponse
import com.intersonik.duygum.network.Api
import com.intersonik.duygum.util.Resource
import javax.inject.Inject

class MymuudRepository @Inject constructor(private val api: Api) : BaseRepository() {

    suspend fun postLogin(login: Login): Resource<LoginResponse> {
        return getResult {
            api.login(login)
        }
    }

    suspend fun postSignUp(signUp: SignupPoco): Resource<LoginResponse> {
        return getResult {
            api.signup(signUp)
        }
    }

    suspend fun verifyEmailCode(verifySignupEmail: VerifySignupEmail): Resource<LoginResponse> {
        return getResult {
            api.verifySignUpEmailCode(verifySignupEmail)
        }
    }

    suspend fun saveUserProfileEdit(saveUserProfileEdit: SaveProfileEditPoco): Resource<LoginResponse> {
        return getResult {
            api.saveUserProfileEdit(saveUserProfileEdit)
        }
    }
    suspend fun getUserInfo(getUserInfo: Cookie ): Resource<UserDto> {
        return getResult {
            api.getUserInfo(getUserInfo)
        }
    }
}
