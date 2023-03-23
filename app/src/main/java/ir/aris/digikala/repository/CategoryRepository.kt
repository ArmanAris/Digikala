package ir.aris.digikala.repository

import ir.aris.digikala.data.model.category.SubCategory
import ir.aris.digikala.data.network.BaseApiResponse
import ir.aris.digikala.data.network.CategoryApiInterface
import ir.aris.digikala.data.network.NetworkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: CategoryApiInterface) : BaseApiResponse() {

    suspend fun getSubCategories(): NetworkResult<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }

}