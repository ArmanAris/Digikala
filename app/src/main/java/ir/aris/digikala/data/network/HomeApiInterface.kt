package ir.aris.digikala.data.network

import ir.aris.digikala.data.model.ResponseResult
import ir.aris.digikala.data.model.home.Slider
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {

    @GET("v1/getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>

}