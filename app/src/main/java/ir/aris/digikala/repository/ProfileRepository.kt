package ir.aris.digikala.repository


import ir.aris.digikala.data.model.profile.LoginRequest
import ir.aris.digikala.data.model.profile.LoginResponse
import ir.aris.digikala.data.network.BaseApiResponse
import ir.aris.digikala.data.network.NetworkResult
import ir.aris.digikala.data.network.ProfileApiInterface
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val api: ProfileApiInterface) :
    BaseApiResponse() {

    suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse> =
        safeApiCall {
            api.login(loginRequest)
        }


}
