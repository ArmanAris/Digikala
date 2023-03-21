package ir.aris.digikala.ui.screen.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ir.aris.digikala.data.model.home.AmazingItem
import ir.aris.digikala.data.network.NetworkResult
import ir.aris.digikala.ui.theme.DigikalaLightGreen
import ir.aris.digikala.ui.theme.DigikalaLightRed
import ir.aris.digikala.viewmodel.HomeViewModel
import ir.truelearn.digikala.ui.screens.home.AmazingOfferCard
import ir.aris.digikala.R


@Composable
fun SuperMarketOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
){

    var superMarketItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val superMarketItemResult by viewModel.superMarketItems.collectAsState()
    when (superMarketItemResult) {
        is NetworkResult.Success -> {
            superMarketItemList = superMarketItemResult.data ?: emptyList()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("7171", "superMarketOfferSection error : ${superMarketItemResult.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.DigikalaLightGreen)
    ) {

        LazyRow(modifier = Modifier.background(MaterialTheme.colors.DigikalaLightGreen)) {

            item {
                AmazingOfferCard(R.drawable.supermarketamazings, R.drawable.fresh)
            }

            items(superMarketItemList) { item ->
                AmazingItem(item = item)
            }

            item {
                AmazingShowMoreItem()
            }


        }

    }

}