package ir.aris.digikala.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ir.aris.digikala.ui.components.RoundedIconBox
import ir.aris.digikala.ui.theme.LocalSpacing
import ir.aris.digikala.R
import ir.aris.digikala.navigation.Screen
import ir.aris.digikala.ui.theme.amber
import ir.aris.digikala.ui.theme.backgroundColor
import ir.aris.digikala.ui.theme.grayCategory
import ir.aris.digikala.util.Constants.AUCTION_URL
import ir.aris.digikala.util.Constants.DIGIJET_URL
import ir.aris.digikala.util.Constants.DIGIPAY_URL
import ir.aris.digikala.util.Constants.DIGIPLUS_URL
import ir.aris.digikala.util.Constants.GIFT_CARD_URL
import ir.aris.digikala.util.Constants.MORE_URL
import ir.aris.digikala.util.Constants.PINDO_URL
import ir.aris.digikala.util.Constants.SHOPPING_URL


@Composable
fun ShowcaseSection(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.backgroundColor)
            .padding(
                horizontal = LocalSpacing.current.semiMedium,
                vertical = LocalSpacing.current.biggerSmall
            )

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                image = painterResource(id = R.drawable.digijet),
                title = stringResource(id = R.string.digikala_jet),
                onClick = onBoxClick(
                    navController = navController,
                    url = DIGIJET_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.auction),
                title = stringResource(id = R.string.digi_style),
                onClick = onBoxClick(
                    navController = navController,
                    url = AUCTION_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digipay),
                title = stringResource(id = R.string.digi_pay),
                onClick = onBoxClick(
                    navController,
                    url = DIGIPAY_URL),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.pindo),
                title = stringResource(id = R.string.pindo),
                bgColor = MaterialTheme.colors.amber,
                onClick = onBoxClick(
                    navController,
                    url = PINDO_URL),
            )

        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                image = painterResource(id = R.drawable.shopping),
                title = stringResource(id = R.string.digi_shopping),
                onClick = onBoxClick(
                    navController,
                    url = SHOPPING_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.giftcard),
                title = stringResource(id = R.string.gift_card),
                onClick = onBoxClick(
                    navController,
                    url = GIFT_CARD_URL),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digiplus),
                title = stringResource(id = R.string.digi_plus),
                onClick = onBoxClick(
                    navController,
                    url = DIGIPLUS_URL),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.more),
                title = stringResource(id = R.string.more),
                bgColor = MaterialTheme.colors.grayCategory,
                onClick = onBoxClick(
                    navController,
                    url = MORE_URL
                ),
            )

        }

    }

}


@Composable
fun onBoxClick(navController: NavController, url: String): () -> Unit =
    { navController.navigate(route = Screen.WebView.route + "?url=${url}") }
