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
import ir.aris.digikala.viewmodel.HomeViewModel
import ir.truelearn.digikala.ui.screens.home.AmazingOfferCard
import ir.aris.digikala.R
import ir.aris.digikala.ui.theme.DigikalaLightRed


@Composable
fun AmazingOfferSection(
    viewModel: HomeViewModel = hiltViewModel(),
) {

    var amazingItemList by remember { mutableStateOf<List<AmazingItem>>(emptyList()) }
    var loading by remember { mutableStateOf(false) }

    val amazingItemResult by viewModel.amazingItems.collectAsState()
    when (amazingItemResult) {
        is NetworkResult.Success -> {
            amazingItemList = amazingItemResult.data ?: emptyList()
            loading = false
            Log.e("7171", "item : ${amazingItemList[0].name}")
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("7171", "AmazingOfferSection error : ${amazingItemResult.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.DigikalaLightRed)) {

        LazyRow(modifier = Modifier.background(MaterialTheme.colors.DigikalaLightRed)) {

            item {
                AmazingOfferCard(R.drawable.amazings, R.drawable.box)
            }
            items(amazingItemList) { item ->
                AmazingItem(item = item)
            }
            item {
                AmazingShowMoreItem()
            }

        }


    }
}