package com.intersonik.duygum.network

import com.intersonik.duygum.data.model.*
import com.intersonik.duygum.data.remote.LoginResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {

    @POST("admin/v1/login")
    suspend fun login(
        @Body Login: Login,
    ): Response<LoginResponse>


    @POST("auth/v1/signup")
    suspend fun signup(
        @Body SignUp: SignupPoco,
    ): Response<LoginResponse>

    @POST("endpoint/v1/verifySignupEmailCode")
    suspend fun verifySignUpEmailCode(
        @Body verifySignupEmail: VerifySignupEmail
    ): Response<LoginResponse>

    @POST("endpoint/v1/getUser")
    suspend fun getUserInfo(
        @Body getUserInfo:Cookie
    ):Response<UserDto>

    @POST("endpoint/v1/saveUserProfileEdit")
    suspend fun saveUserProfileEdit(
        @Body saveUserProfileEdit: SaveProfileEditPoco
    ): Response<LoginResponse> // değiştirilecek


}

