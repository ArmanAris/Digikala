package ir.aris.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.aris.digikala.navigation.BottomNavigationBar
import ir.aris.digikala.navigation.NavGraph
import ir.aris.digikala.ui.theme.DigikalaTheme
import ir.aris.digikala.util.Constants.PERSIAN_LANG
import ir.aris.digikala.util.LocaleUtils

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaTheme {

                navController = rememberNavController()

                LocaleUtils.setLocale(LocalContext.current, PERSIAN_LANG)

                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) { //androidx.compose.ui.unit.LayoutDirection
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController, onItemClick = {
                                navController.navigate(it.route)
                            })
                        }
                    ) {

                        NavGraph(navController = navController)

                    }
                }

            }
        }
    }
}

