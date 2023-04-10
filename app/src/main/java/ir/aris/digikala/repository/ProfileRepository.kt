package ir.aris.digikala.repository

import ir.aris.digikala.data.network.BaseApiResponse
import ir.aris.digikala.data.network.ProfileApiInterface
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val api: ProfileApiInterface) : BaseApiResponse() {

}