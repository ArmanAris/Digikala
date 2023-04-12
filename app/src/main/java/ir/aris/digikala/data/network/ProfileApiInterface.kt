package ir.aris.digikala.data.network

import ir.aris.digikala.data.model.ResponseResult
import ir.aris.digikala.data.model.profile.LoginRequest
import ir.aris.digikala.data.model.profile.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ProfileApiInterface {

    @POST("v1/login")
    suspend fun login(
        @Body login : LoginRequest
    ) : Response<ResponseResult<LoginResponse>>


}
