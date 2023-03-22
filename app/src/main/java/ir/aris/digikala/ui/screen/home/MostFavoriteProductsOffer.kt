package ir.aris.digikala.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.aris.digikala.R
import ir.aris.digikala.data.model.home.StoreProduct
import ir.aris.digikala.ui.theme.*
import ir.aris.digikala.util.DigitHelper


@Composable
fun MostFavoriteProductsOffer(item : StoreProduct) {

    Column(
        modifier = Modifier
            .width(170.dp)
            .padding(
                vertical = MaterialTheme.spacing.semiLarge,
                horizontal = MaterialTheme.spacing.semiSmall
            ),
    ) {

       Row {

           Column(
               modifier = Modifier
                   .weight(1f)
                   .padding(vertical = MaterialTheme.spacing.small)
           ) {

               Column(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(vertical = MaterialTheme.spacing.extraSmall)
               ) {


                   Image(
                       painter = rememberAsyncImagePainter(item.image),
                       contentDescription = "",
                       modifier = Modifier
                           .fillMaxWidth()
                           .height(130.dp),
                       contentScale = ContentScale.FillBounds
                   )

               }

               Spacer(modifier = Modifier.height(10.dp))

               Column(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(vertical = MaterialTheme.spacing.small)
               ) {

                   Text(
                       text = item.name,
                       modifier = Modifier
                           .fillMaxSize()
                           .height(48.dp)
                           .padding(horizontal = MaterialTheme.spacing.small),
                       style = MaterialTheme.typography.h6,
                       fontWeight = FontWeight.SemiBold,
                       color = MaterialTheme.colors.darkText,
                       maxLines = 2,
                       overflow = TextOverflow.Ellipsis
                   )

                   Spacer(modifier = Modifier.height(10.dp))

                   Row(
                       modifier = Modifier
                           .fillMaxWidth(),
                       horizontalArrangement = Arrangement.Center,
                       verticalAlignment = Alignment.CenterVertically
                   ) {

                       Icon(
                           painter = painterResource(id = R.drawable.in_stock),
                           contentDescription = "",
                           modifier = Modifier
                               .size(22.dp)
                               .padding(2.dp),
                           tint = MaterialTheme.colors.DarkCyan
                       )
                       Text(
                           text = item.seller,
                           style = MaterialTheme.typography.extraSmall,
                           fontWeight = FontWeight.SemiBold,
                           color = MaterialTheme.colors.semiDarkText,
                       )

                   }

                   Spacer(modifier = Modifier.height(10.dp))


                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(horizontal = MaterialTheme.spacing.small),
                       horizontalArrangement = Arrangement.SpaceBetween,
                       verticalAlignment = Alignment.Top
                   ) {

                       Box(
                           modifier = Modifier
                               .width(40.dp)
                               .height(24.dp)
                               .background(
                                   color = MaterialTheme.colors.DigikalaDarkRed,
                                   shape = CircleShape
                               )
                               .wrapContentWidth(Alignment.CenterHorizontally)
                               .wrapContentHeight(Alignment.CenterVertically)
                       ) {
                           Text(
                               text = "${DigitHelper.digitByLocate(item.discountPercent.toString())}%",
                               color = Color.White,
                               style = MaterialTheme.typography.h6,
                               fontWeight = FontWeight.Bold,
                           )
                       }


                       Column {

                           Row {
                               Text(
                                   text = DigitHelper.digitByLocateAndSeparator(
                                       DigitHelper.applyDiscount(item.price , item.discountPercent)
                                           .toString()),
                                   style = MaterialTheme.typography.body2,
                                   fontWeight = FontWeight.SemiBold,
                               )

                               Image(
                                   painter = painterResource(id = R.drawable.toman),
                                   contentDescription = "",
                                   modifier = Modifier
                                       .size(MaterialTheme.spacing.semiLarge)
                                       .padding(horizontal = MaterialTheme.spacing.extraSmall)
                               )

                           }

                           Text(
                               text = DigitHelper.digitByLocateAndSeparator(item.price.toString()),
                               color = Color.LightGray,
                               style = MaterialTheme.typography.body2,
                               textDecoration = TextDecoration.LineThrough
                           )
                       }

                   }


               }


           }


           Divider(
               Modifier
                   .width(1.dp)
                   .height(320.dp)
                   .alpha(0.4f),
               color = Color.LightGray
           )
       }




    }


}