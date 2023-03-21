package ir.aris.digikala.ui.screen.home


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.aris.digikala.viewmodel.HomeViewModel
import ir.truelearn.digikala.ui.screens.home.CategoryListSection
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    Home(navController = navController)
}


@Composable
fun Home(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    /*
اگر در موقع بازگشت از صفحه وب ویو زیان تغییر کرد از کد زیر استفاده می کنیم.
کد زیر دوباره زبان را ست می کند
    */
    // LocaleUtils.setLocale(LocalContext.current, Constants.USER_LANGUAGE)

    LaunchedEffect(true) {
        refreshDataFromServer(viewModel)
    }

    SwipeRefreshSection(navController = navController, viewModel = viewModel)

}

@Composable
fun SwipeRefreshSection(
    navController: NavHostController,
    viewModel: HomeViewModel,
) {
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            refreshScope.launch {
                refreshDataFromServer(viewModel)
                Log.e("7171", "swipeRefresh")
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(bottom = 60.dp)
        ) {

            item { SearchBarSection() }
            item { TopSliderSection() }
            item { ShowcaseSection(navController) }
            item { AmazingOfferSection() }
            item { ProposalCardSection() }
            item { SuperMarketOfferSection() }
            item { CategoryListSection() }
            item { CenterBannerSection(1) }
            item { BestSellerOfferSection() }
            item { CenterBannerSection(2) }

            item { CenterBannerSection(3) }

            item { CenterBannerSection(4) }

            item { CenterBannerSection(5) }


        }
    }
}

private suspend fun refreshDataFromServer(viewModel: HomeViewModel) {
    // type 1 view model
    viewModel.getAllDataFromServer()

    // type 2 view model
    /*
    viewModel.getSlider()
    viewModel.getAmazingItems()
    */
}