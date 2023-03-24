package ir.aris.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aris.digikala.data.model.home.StoreProduct
import ir.aris.digikala.data.network.NetworkResult
import ir.aris.digikala.repository.BasketRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) : ViewModel() {

    val suggestedList = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    fun getSuggestedItems(){
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItems())
        }
    }

}