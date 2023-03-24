package ir.aris.digikala.repository

import ir.aris.digikala.data.model.home.StoreProduct
import ir.aris.digikala.data.network.BaseApiResponse
import ir.aris.digikala.data.network.BasketApiInterface
import ir.aris.digikala.data.network.NetworkResult
import javax.inject.Inject


class BasketRepository @Inject constructor(private val api: BasketApiInterface) : BaseApiResponse() {

    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }

}