package ir.aris.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.aris.digikala.navigation.BottomNavigationBar
import ir.aris.digikala.navigation.NavGraph
import ir.aris.digikala.ui.theme.DigikalaTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaTheme {

                navController = rememberNavController()

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

