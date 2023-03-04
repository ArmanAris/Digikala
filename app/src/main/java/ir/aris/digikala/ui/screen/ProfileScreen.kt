package ir.aris.digikala.ui.screen


import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import ir.aris.digikala.MainActivity
import ir.aris.digikala.util.Constants.ENGLISH_LANG
import ir.aris.digikala.util.Constants.PERSIAN_LANG
import ir.aris.digikala.viewmodel.DataStoreViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel(),
) {

    val activity = LocalContext.current as Activity

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "ProfileScreen")
        Button(onClick = {
            dataStore.saveUserLanguage(PERSIAN_LANG)
            //  activity.finish()
            //  activity.startActivity(Intent(activity, MainActivity::class.java))
            activity.apply {
                finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }

        }) {
            Text(text = "fa")
        }
        Button(onClick = {
            dataStore.saveUserLanguage(ENGLISH_LANG)
            activity.apply {
                finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }) {
            Text(text = "en")
        }
    }

}