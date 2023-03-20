package ir.aris.digikala.repository

import ir.aris.digikala.data.model.home.AmazingItem
import ir.aris.digikala.data.model.home.Slider
import ir.aris.digikala.data.network.BaseApiResponse
import ir.aris.digikala.data.network.HomeApiInterface
import ir.aris.digikala.data.network.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse() {

    suspend fun getSlider(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }

    suspend fun getAmazingItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingItems()
        }

}