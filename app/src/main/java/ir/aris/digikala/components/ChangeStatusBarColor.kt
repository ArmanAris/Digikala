package ir.aris.digikala.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ir.aris.digikala.navigation.Screen
import ir.aris.digikala.ui.theme.Purple200

@Composable
fun ChangeStatusBarColor(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()

    when (navBackStackEntry?.destination?.route) {

        Screen.Splash.route -> {
            SideEffect {
                systemUiController.setStatusBarColor(Purple200)
            }
        }
        else -> {
            SideEffect {
                systemUiController.setStatusBarColor(Color.White)
            }
        }

    }

}