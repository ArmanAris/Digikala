package ir.aris.digikala.ui.screen.basket


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import ir.aris.digikala.R
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.aris.digikala.ui.theme.digikalaRed
import ir.aris.digikala.ui.theme.spacing
import ir.aris.digikala.viewmodel.BasketViewModel


@Composable
fun BasketScreen(navController: NavHostController) {
    Basket(navController)

}

@Composable
fun Basket(
    navController: NavController,
    viewModel: BasketViewModel = hiltViewModel(),
) {


    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val tabTitles = listOf(
        stringResource(id = R.string.cart),
        stringResource(id = R.string.next_cart_list)
    )

    Column {

        TabRow(
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.medium),
            selectedTabIndex = selectedTabIndex,
            contentColor = MaterialTheme.colors.digikalaRed,
            backgroundColor = Color.White,
            indicator = { line ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(line[selectedTabIndex])
                        .height(3.dp)
                        .background(Color.Red)

                )
            }
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = (selectedTabIndex == index),
                    onClick = {
                        selectedTabIndex = index
                    },
                    selectedContentColor = MaterialTheme.colors.digikalaRed,
                    unselectedContentColor = Color.Gray,
                    text = {
                        Row {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> ShoppingCart()
            1 -> NextShoppingList()
        }

    }

}