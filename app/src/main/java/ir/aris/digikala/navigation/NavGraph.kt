package ir.aris.digikala.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.aris.digikala.ui.screen.*
import ir.aris.digikala.ui.screen.basket.BasketScreen
import ir.aris.digikala.ui.screen.category.CategoryScreen
import ir.aris.digikala.ui.screen.home.HomeScreen
import ir.aris.digikala.ui.screen.home.WebPageScreen

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

        composable(
            route = Screen.WebView.route + "?url={url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            })
        ) {
            val url = it.arguments?.getString("url")
            url?.let {
                WebPageScreen(navController = navController, url = url)
            }
        }


    }

}












