package ir.aris.digikala.ui.screen.basket

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.aris.digikala.data.model.basket.CartItem
import ir.aris.digikala.data.model.basket.CartStatus
import ir.aris.digikala.viewmodel.BasketViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NextShoppingList(
    viewModel: BasketViewModel = hiltViewModel()
) {

    val nextCartItems = remember {
        mutableStateOf(emptyList<CartItem>())
    }

    LaunchedEffect(true) {
        viewModel.nextCartItems.collectLatest { list ->
            nextCartItems.value = list
        }
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 60.dp),
    ) {

        if (nextCartItems.value.isEmpty()) {
            item { EmptyNextShoppingList() }
        } else {

            items(nextCartItems.value) { item ->
                CartItemCard(item , CartStatus.NEXT_CART)
            }

        }


    }


}