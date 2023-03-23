package ir.aris.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.aris.digikala.ui.components.AppConfig
import ir.aris.digikala.ui.components.ChangeStatusBarColor
import ir.aris.digikala.navigation.BottomNavigationBar
import ir.aris.digikala.navigation.NavGraph
import ir.aris.digikala.ui.theme.DigikalaTheme
import ir.aris.digikala.util.Constants.ENGLISH_LANG
import ir.aris.digikala.util.Constants.PERSIAN_LANG
import ir.aris.digikala.util.Constants.USER_LANGUAGE
import ir.aris.digikala.util.LocaleUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaTheme() {

                navController = rememberNavController()

                ChangeStatusBarColor(navController)

                AppConfig()

                Log.e("7171", USER_LANGUAGE)

                val direction = if (USER_LANGUAGE == ENGLISH_LANG) {
                    LayoutDirection.Ltr
                } else {
                    LayoutDirection.Rtl
                }

                LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)

                CompositionLocalProvider(LocalLayoutDirection provides direction) { //androidx.compose.ui.unit.LayoutDirection
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

