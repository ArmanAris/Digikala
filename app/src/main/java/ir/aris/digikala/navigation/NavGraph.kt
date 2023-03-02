package ir.aris.digikala.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.aris.digikala.ui.screen.*

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Category.route) {
            CategoryScreen(navController = navController)
        }
        composable(Screen.Basket.route) {
            BasketScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }

}












